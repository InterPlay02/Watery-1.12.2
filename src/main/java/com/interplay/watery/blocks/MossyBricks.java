package com.interplay.watery.blocks;

import com.interplay.watery.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MossyBricks extends BlockBase
{
	public MossyBricks(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 1);
		//setLightLevel(0.0F);
		//setLightOpacity(0);
		//setBlockUnbreakable();
	}
}
