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
	//Esse ItemStackHandler permite que a classe "EnergyGenerator" acesse o que h� no invent�rio desta TileEntity.
	public ItemStackHandler handler = new ItemStackHandler(1);
	
	//Esta linha abaixo define o armazenamento de energia para esta Tile Entity. 
	private ModEnergyStorage storage = new ModEnergyStorage(100000);
	
	//Esta linha abaixo � usada para facilitar na manipula��o da energia armazenada.
	public int energy = storage.getEnergyStored();
	
	//Esta linha abaixo define que h� um nome personalizado para esta Tile Entity.
	@SuppressWarnings("unused")
	private String customName;
	public int cookTime;

	@Override
	public void update()
	{
		//Tudo aqui dentro dessa parte do update, � lido vinte vezes por segundo.
		//E aqui diz: Se o slot zero (que � o handler) n�o estiver vazio e, se o item que estiver l� for um do tipo 'combust�vel', ent�o...
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)))
		{
			cookTime++;//Esta linha faz o tempo/momento de processamento ir subindo +1.
			if(cookTime == 25) //Essa linha diz: Uma vez que o cookTime chegue aos 25.
			{
				//Ent�o a energia vai receber a si mesma + a quantidade setada.
				energy += getFuelValue(handler.getStackInSlot(0));
				handler.getStackInSlot(0).shrink(1); //Ent�o, nesta linha, o item que est� no slot de itens (handler) ser� diminu�do em 1.
				cookTime = 0;//Ent�o o tempo/momento de processamento volta ao zero.
				
			}
		}
	}
	
	private boolean isItemFuel(ItemStack stack)
	{
		//Essa parte checa se o item � um do tipo 'combust�vel'.
		//Se for maior que zero, ent�o � combust�vel.
		return getFuelValue(stack) > 0;
	}
	
	private int getFuelValue(ItemStack stack)
	{
		//Essa parte aqui trabalha junto com a de cima.
		//Aqui diz: Se o item for (no caso: Carv�o), ent�o diz que gera 200 RF/t.
		if(stack.getItem() == Items.COAL) return 200;
		else return 0; //Se n�o for, diz que gera zero.
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		//Essa parte aqui checa a capacidade de se relacionar com energia e a capacidade de manipula��o de itens.
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
		//Essa parte aqui � usada quando sa�mos do jogo.
		super.writeToNBT(compound); //Essa parte aqui salva os itens no invent�rio desta tile entity
		compound.setTag("Inventory", this.handler.serializeNBT()); //E, nesta linha, os converte para NBT values.
		compound.setInteger("CookTime", cookTime); //Nesta linha, � salvo o tempo/momento de processamento.
		compound.setInteger("GuiEnergy", this.energy); //Nesta, � salvo a quantidade de energia. 
		compound.setString("Name", this.getDisplayName().toString());//E nesta, � salvo o nome personalizado.
		this.storage.writeToNBT(compound);//E aqui � onde, de fato, os dados NBT s�o ordenados a serem salvos.
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		//Essa parte aqui � usada quando entramos no jogo.
		super.readFromNBT(compound);//Essa parte aqui � usada para ler os dados NBT que foram salvos no "compound".
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));//Nesta linha os dados s�o des-serializados ao invent�rio da Tile entity.
		this.cookTime = compound.getInteger("CookTime");//Nesta linha, o tempo/momento de processamento � carregado. 
		this.energy = compound.getInteger("GuiEnergy");//Nesta linha, a quantidade de energia.
		this.customName = compound.getString("Name");//E nesta linha, o nome personalizado.
		this.storage.readFromNBT(compound);//Nesta linha, tudo isso � lido e carregado ao jogo.
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		//Essa parte aqui procura dentro do arquivo lang o nome traduzido desta Tile entity para ser exibido na gui.
		return new TextComponentTranslation("container.energy_generator");
	}
	
	public int getEnergyStored()
	{
		//Essa parte � pra mostrar a quantidade de energia que est� armazenada
		return this.energy;
	}
	
	public int getMaxEnergyStored()
	{
		//Essa parte � pra saber qual � o m�ximo de energia armazenada.
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
		//Essa parte calcula o qu�o distante o player est� da tile entity, para saber se pode ou n�o abrir a gui.
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
}
