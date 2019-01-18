package com.interplay.watery.util.handlers;

import com.interplay.watery.blocks.containers.ContainerEnergyGenerator;
import com.interplay.watery.blocks.guis.GuiEnergyGenerator;
import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;
import com.interplay.watery.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ENERGY_GENERATOR) return new ContainerEnergyGenerator(player.inventory, (TileEntityEnergyGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		else return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ENERGY_GENERATOR) return new GuiEnergyGenerator(player.inventory, (TileEntityEnergyGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		else return null;
	}
}
