package com.interplay.watery.blocks;

import java.util.Random;

import com.interplay.watery.init.ModItems;
import com.interplay.watery.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class LimestoneBlock extends BlockBase
{
	public LimestoneBlock(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return ModItems.LIMESTONE;
    }
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 3;
		int min = 1;
		return rand.nextInt(max) + min;
	}
}
