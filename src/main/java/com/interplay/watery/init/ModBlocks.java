package com.interplay.watery.init;

import java.util.ArrayList;
import java.util.List;

import com.interplay.watery.blocks.Box;
import com.interplay.watery.blocks.ConcreteBlock;
import com.interplay.watery.blocks.LimestoneBlock;
import com.interplay.watery.blocks.MossyBricks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block CONCRETE_BLOCK = new ConcreteBlock("concrete_block", Material.ROCK);
	public static final Block MOSSY_BRICKS = new MossyBricks("mossy_bricks", Material.ROCK);
	public static final Block LIMESTONE_BLOCK = new LimestoneBlock("limestone_block", Material.ROCK);
	//public static final Block ENERGY_GENERATOR = new EnergyGenerator("energy_generator");
	
	//public static final Block CRUSHER = new MachineCrusher("crusher");
	//public static final Block ENERGY_GENERATOR = new EnergyGenerator("energy_generator");
	public static final Block BOX = new Box("box", Material.WOOD);
	
}
