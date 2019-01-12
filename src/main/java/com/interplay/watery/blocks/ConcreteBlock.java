package com.interplay.watery.blocks;

import com.interplay.watery.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ConcreteBlock extends BlockBase
{
	public ConcreteBlock(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 2);
	}	
}
