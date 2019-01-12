package com.interplay.watery.init;

import java.util.ArrayList;
import java.util.List;

import com.interplay.watery.blocks.ConcreteBlock;
import com.interplay.watery.blocks.LimestoneBlock;
import com.interplay.watery.blocks.MossyBricks;

//import com.interplay.watery.blocks.EnergyGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block CONCRETE_BLOCK = new ConcreteBlock("concrete_block", Material.ROCK);
	public static final Block MOSSY_BRICKS = new LimestoneBlock("mossy_bricks", Material.ROCK);
	public static final Block LIMESTONE_BLOCK = new MossyBricks("limestone_block", Material.ROCK);
	//public static final Block ENERGY_GENERATOR = new EnergyGenerator("energy_generator");
	
}
