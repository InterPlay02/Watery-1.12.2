package com.interplay.watery.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmeltingRecipes
{
	public static void init()
	{
		GameRegistry.addSmelting(ModItems.CONCRETE, new ItemStack(ModBlocks.CONCRETE_BLOCK, 1), 1.0f);
	}
}
