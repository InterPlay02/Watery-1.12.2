package com.interplay.watery.blocks;

import com.interplay.watery.Main;
import com.interplay.watery.init.ModBlocks;
import com.interplay.watery.init.ModItems;
import com.interplay.watery.util.IHasModel;
import com.interplay.watery.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Box extends BlockBase implements IHasModel
{
	//Aqui é definido o tamanho do hitbox do bloco
	public static final AxisAlignedBB BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	//Aqui é definido que o bloco gira apenas na horizontal (no eixo y).
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	//Aqui são importados os aspectos básicos de bloco do BlockBase e ainda são adicionadas estas propriedades.
	public Box(String name, Material material)
	{
		super(name, Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabwatery);
		setSoundType(SoundType.WOOD);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	//Aqui fica definido que a frente do bloco será, por padrão, o lado norte do bloco
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		
		if(facing.getAxis() == EnumFacing.Axis.Y)
		{
			facing = EnumFacing.NORTH;
		}
		
		return getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	//Aqui dizemos que o bloco deve ser colocado sempre de acordo com a direção que o player
	//estiver olhando horizontalmente, porém oposta.
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
    {
	  return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	//Aqui o jogo verifica se o bloco pode ser colocado ali.
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if(!this.canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.BOX));
		}
	}
	
	//Aqui nós dizemos que o getBoundingBox deve olhar para as medidas que se encontram na variável chamada BOX.
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOX;
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
	
	//Aqui dizemos que o bloco não é um bloco perfeito. Tem outro formato.
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

	//Aqui o modelo 3D é registrado.
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
