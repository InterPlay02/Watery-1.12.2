package com.interplay.watery.blocks.machines;

import com.interplay.watery.Main;
import com.interplay.watery.blocks.BlockBase;
import com.interplay.watery.init.ModBlocks;
import com.interplay.watery.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EnergyGenerator extends BlockBase
{
	//Aqui é definido o tamanho do hitbox do bloco, sendo 'x' leste-/oeste+ e 'z' norte-/sul+.
	public static final AxisAlignedBB ENERGY_GENERATOR_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 2.0D);
	public static final AxisAlignedBB ENERGY_GENERATOR_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 1.0D, 1.0D, 2.0D, -1.0D);
	public static final AxisAlignedBB ENERGY_GENERATOR_EAST = new AxisAlignedBB(-1.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	public static final AxisAlignedBB ENERGY_GENERATOR_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 1.0D);
	
	//Aqui nós dizemos que o getBoundingBox deve olhar para as medidas que se encontram na variável chamada ENERGY_GENERATOR.
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch(((EnumFacing)state.getValue(FACING)))
        {
            case NORTH:
            default:
                return ENERGY_GENERATOR_NORTH;
            case EAST:
                return ENERGY_GENERATOR_EAST;
            case WEST:
                return ENERGY_GENERATOR_WEST;
            case SOUTH:
                return ENERGY_GENERATOR_SOUTH;
        }
	}
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public EnergyGenerator(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	public final EnumFacing getFacing(IBlockState state)
	{
		return state.getValue(FACING);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) 
	{
		if (!worldIn.isRemote) 
        {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing)state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	//Aqui dizemos que o bloco não é opaco.
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	//Aqui dizemos que o bloco não é um CUBO perfeito. Tem outro formato.
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	//Aqui dizemos que o bloco não ocupa o formato 1x1x1 perfeito.
	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
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
	
	//Aqui o modelo 3D é registrado, de maneira que apareça no inventário. Isto se refere ao item dentro da pasta "resources/models/item".
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
