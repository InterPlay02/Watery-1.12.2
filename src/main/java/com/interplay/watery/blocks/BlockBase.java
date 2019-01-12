package com.interplay.watery.blocks;

import com.interplay.watery.Main;
import com.interplay.watery.init.ModBlocks;
import com.interplay.watery.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.WATERY);
		
		ModBlocks.BLOCKS.add(this);
		
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
