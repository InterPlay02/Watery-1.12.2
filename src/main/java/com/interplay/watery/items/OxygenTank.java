package com.interplay.watery.items;

import com.interplay.watery.Main;
import com.interplay.watery.init.ModItems;
import com.interplay.watery.items.armor.ModelOxygenTank;
import com.interplay.watery.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class OxygenTank extends ItemArmor implements IHasModel
{

	public OxygenTank(String name, CreativeTabs tab, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, 1, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		if(itemStack != ItemStack.EMPTY)
		{
			if(itemStack.getItem() instanceof ItemArmor)
			{
				ModelOxygenTank model2 = new ModelOxygenTank();
				
				model2.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST;
			
				model2.isChild = _default.isChild;
				model2.isRiding = _default.isRiding;
				model2.isRiding = _default.isSneak;
				model2.rightArmPose = _default.rightArmPose;
				model2.leftArmPose = _default.leftArmPose;
				
				return model2;
			}
			
		}
		
		return null;
	}
	
}
