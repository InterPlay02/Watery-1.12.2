package com.interplay.watery.items.armor;

import com.interplay.watery.Main;
import com.interplay.watery.init.ModItems;
import com.interplay.watery.util.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel
{
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabwatery);
		setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
