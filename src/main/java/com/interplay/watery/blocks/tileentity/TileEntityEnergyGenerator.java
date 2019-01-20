package com.interplay.watery.blocks.tileentity;

import com.interplay.watery.energy.ModEnergyStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityEnergyGenerator extends TileEntity implements ITickable
{
	//Esse ItemStackHandler permite que a classe "EnergyGenerator" acesse o que há no inventário desta TileEntity.
	public ItemStackHandler handler = new ItemStackHandler(1);
	
	//Esta linha abaixo define o armazenamento de energia para esta Tile Entity. 
	private ModEnergyStorage storage = new ModEnergyStorage(100000);
	
	//Esta linha abaixo é usada para facilitar na manipulação da energia armazenada.
	public int energy = storage.getEnergyStored();
	
	//Esta linha abaixo define que há um nome personalizado para esta Tile Entity.
	@SuppressWarnings("unused")
	private String customName;
	public int cookTime;

	@Override
	public void update()
	{
		//Tudo aqui dentro dessa parte do update, é lido vinte vezes por segundo.
		//E aqui diz: Se o slot zero (que é o handler) não estiver vazio e, se o item que estiver lá for um do tipo 'combustível', então...
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)))
		{
			cookTime++;//Esta linha faz o tempo/momento de processamento ir subindo +1.
			if(cookTime == 25) //Essa linha diz: Uma vez que o cookTime chegue aos 25.
			{
				//Então a energia vai receber a si mesma + a quantidade setada.
				energy += getFuelValue(handler.getStackInSlot(0));
				handler.getStackInSlot(0).shrink(1); //Então, nesta linha, o item que está no slot de itens (handler) será diminuído em 1.
				cookTime = 0;//Então o tempo/momento de processamento volta ao zero.
				
			}
		}
	}
	
	private boolean isItemFuel(ItemStack stack)
	{
		//Essa parte checa se o item é um do tipo 'combustível'.
		//Se for maior que zero, então é combustível.
		return getFuelValue(stack) > 0;
	}
	
	private int getFuelValue(ItemStack stack)
	{
		//Essa parte aqui trabalha junto com a de cima.
		//Aqui diz: Se o item for (no caso: Carvão), então diz que gera 200 RF/t.
		if(stack.getItem() == Items.COAL) return 200;
		else return 0; //Se não for, diz que gera zero.
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		//Essa parte aqui checa a capacidade de se relacionar com energia e a capacidade de manipulação de itens.
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T)this.handler;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		//Essa parte aqui é usada quando saímos do jogo.
		super.writeToNBT(compound); //Essa parte aqui salva os itens no inventário desta tile entity
		compound.setTag("Inventory", this.handler.serializeNBT()); //E, nesta linha, os converte para NBT values.
		compound.setInteger("CookTime", cookTime); //Nesta linha, é salvo o tempo/momento de processamento.
		compound.setInteger("GuiEnergy", this.energy); //Nesta, é salvo a quantidade de energia. 
		compound.setString("Name", this.getDisplayName().toString());//E nesta, é salvo o nome personalizado.
		this.storage.writeToNBT(compound);//E aqui é onde, de fato, os dados NBT são ordenados a serem salvos.
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		//Essa parte aqui é usada quando entramos no jogo.
		super.readFromNBT(compound);//Essa parte aqui é usada para ler os dados NBT que foram salvos no "compound".
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));//Nesta linha os dados são des-serializados ao inventário da Tile entity.
		this.cookTime = compound.getInteger("CookTime");//Nesta linha, o tempo/momento de processamento é carregado. 
		this.energy = compound.getInteger("GuiEnergy");//Nesta linha, a quantidade de energia.
		this.customName = compound.getString("Name");//E nesta linha, o nome personalizado.
		this.storage.readFromNBT(compound);//Nesta linha, tudo isso é lido e carregado ao jogo.
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		//Essa parte aqui procura dentro do arquivo lang o nome traduzido desta Tile entity para ser exibido na gui.
		return new TextComponentTranslation("container.energy_generator");
	}
	
	public int getEnergyStored()
	{
		//Essa parte é pra mostrar a quantidade de energia que está armazenada
		return this.energy;
	}
	
	public int getMaxEnergyStored()
	{
		//Essa parte é pra saber qual é o máximo de energia armazenada.
		return this.getMaxEnergyStored();
	}
	
	public int getField(int id)
	{
		switch(id)
		{
		case 0:
			return this.energy;
		case 1:
			return this.cookTime;
		default:
			return 0;
		}
	}
	
	public void setField(int id, int value)
	{
		switch(id)
		{
		case 0:
			this.energy = value;
		case 1:
			this.cookTime = value;
		}
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		//Essa parte calcula o quão distante o player está da tile entity, para saber se pode ou não abrir a gui.
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
}
