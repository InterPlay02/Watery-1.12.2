package com.interplay.watery.blocks;

import com.interplay.watery.Main;
import com.interplay.watery.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnergyGenerator extends BlockBase
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public EnergyGenerator(String name, Material material)
	{
		super(name, material);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
        if(!worldIn.isRemote)
        {
            playerIn.openGui(Main.instance, Reference.GUI_ENERGY_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }        
        return true;
    } 
}
