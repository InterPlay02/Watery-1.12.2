package com.interplay.watery.items;

import com.interplay.watery.Main;
import com.interplay.watery.init.ModItems;
import com.interplay.watery.items.armor.ModelOxygenMask;
import com.interplay.watery.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class OxygenMask extends ItemArmor implements IHasModel
{

	public OxygenMask(String name, CreativeTabs tab, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn)
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
	
	public ModelOxygenMask model1 = new ModelOxygenMask();
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		if(itemStack != ItemStack.EMPTY)
		{
			if(itemStack.getItem() instanceof ItemArmor)
			{
				model1.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				
				model1.isChild = _default.isChild;
				model1.isRiding = _default.isRiding;
				model1.isRiding = _default.isSneak;
				model1.rightArmPose = _default.rightArmPose;
				model1.leftArmPose = _default.leftArmPose;
				
				return model1;
			}
			
		}
		
		return null;
	}
	
}
