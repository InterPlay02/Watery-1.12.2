package com.interplay.watery.blocks.machines;

import java.util.Random;

import com.interplay.watery.Main;
import com.interplay.watery.blocks.BlockBase;
import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;
import com.interplay.watery.init.ModBlocks;
import com.interplay.watery.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EnergyGenerator extends BlockBase implements ITickable
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool GENERATING = PropertyBool.create("generating");
	
	public EnergyGenerator(String name)
	{
		//Essa parte designa o tipo de material que o bloco terá, o som ao caminhar sobre ele
		//e a rotação dele junto com o estado padrão dele (nesse caso: não gerando energia).
		super(name, Material.IRON);
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(GENERATING, false));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
	EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		//Essa parte checa: Se o mundo não for remoto, então, abrir a gui do bloco em questão.
		if(!worldIn.isRemote)
		{
			//A gui deve ter uma textura e deve estar dentro da classe "Reference", com uma ID própria.
			playerIn.openGui(Main.instance, Reference.GUI_ENERGY_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		//Essa parte diz que o bloco em questão possui sim uma TliEntity.
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		//Visto que a parte de cima diz que há uma TileEntity,
		//então esta parte aqui diz para que essa TileEntiy seja declarada "criada". 
		return new TileEntityEnergyGenerator();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		//Essa parte aqui diz:
		//Essa TileEntity, chamada "tileentity" é igual a essa TileEntity nesta posição.
		TileEntityEnergyGenerator tileentity = (TileEntityEnergyGenerator)worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.ENERGY_GENERATOR);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if(!worldIn.isRemote)
		{
			IBlockState north = worldIn.getBlockState(pos.north());
			IBlockState south = worldIn.getBlockState(pos.south());
			IBlockState east = worldIn.getBlockState(pos.east());
			IBlockState west = worldIn.getBlockState(pos.west());
			EnumFacing face = (EnumFacing)state.getValue(FACING);
			
			if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
			else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
			else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
			else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
			worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
		}
	}
	
	public static void setState(boolean active, World worldIn, BlockPos pos)
	{
		IBlockState state = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if(active) worldIn.setBlockState(pos, ModBlocks.ENERGY_GENERATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(GENERATING, true), 3);
		else worldIn.setBlockState(pos, ModBlocks.ENERGY_GENERATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(GENERATING, false), 3);
		
		if (tileentity != null)
		{
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
	float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
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
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {GENERATING, FACING});
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
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.ENERGY_GENERATOR);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	public static final AxisAlignedBB ENERGY_GENERATOR_AABB = new AxisAlignedBB(0, 0, 0, 1, 2, 2);
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return ENERGY_GENERATOR_AABB;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
