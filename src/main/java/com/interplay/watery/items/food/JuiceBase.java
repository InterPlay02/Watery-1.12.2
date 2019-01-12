package com.interplay.watery.items.food;

import com.interplay.watery.items.food.FoodBase;
import com.interplay.watery.Main;
import com.interplay.watery.init.ModItems;
import com.interplay.watery.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;

public class JuiceBase extends FoodBase implements IHasModel
{
	public JuiceBase(String name, int amount, float saturation)
	{
		super(name, amount, saturation, false);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
				
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
