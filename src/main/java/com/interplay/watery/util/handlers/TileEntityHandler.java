package com.interplay.watery.util.handlers;

import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;
import com.interplay.watery.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityEnergyGenerator.class, new ResourceLocation(Reference.MOD_ID + ":energy_generator"));
	}
}
