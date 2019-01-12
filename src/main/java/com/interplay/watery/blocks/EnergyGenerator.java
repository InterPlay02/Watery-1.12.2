/*package com.interplay.watery.blocks;

//THIS IS UNFINNISHED!!

import com.interplay.watery.Main;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnergyGenerator extends BlockBase
{
	public EnergyGenerator(String name)
	{
		super(name, Material.IRON);
		setCreativeTab(CreativeTabs.REDSTONE);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Main.instance, modGuiId, world, x, y, z);
		}
	}
}
*/