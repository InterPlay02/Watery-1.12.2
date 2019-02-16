package com.interplay.watery.util.handlers;

import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CapabilityHandler
{
	@SubscribeEvent
	public void attachCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		if(event.getObject() instanceof TileEntityEnergyGenerator)
		{
			System.out.print("Capability handler loaded");
		}
		
	}
}
