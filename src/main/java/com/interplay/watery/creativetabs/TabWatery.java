package com.interplay.watery.creativetabs;

import com.interplay.watery.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabWatery extends CreativeTabs
{
	public TabWatery(String label)
	{
		super("tabwatery");
		this.setBackgroundImageName("watery.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.MASK);
	}
	
}
