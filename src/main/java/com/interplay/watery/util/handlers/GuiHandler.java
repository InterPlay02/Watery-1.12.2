package com.interplay.watery.util.handlers;

import com.interplay.watery.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static int getGuiID()
	{
		return Reference.GUI_BOX;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID != getGuiID()) {
			System.err.println("ID inválido: era esperado " + getGuiID() + ", mas foi recebido " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityBox) {
			TileEntityBox tileEntityInventoryBasic = (TileEntityBox) tileEntity;
			return new ContainerBox(player.inventory, tileEntityInventoryBasic);
		}
		return null;
		
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
		
	}
}
