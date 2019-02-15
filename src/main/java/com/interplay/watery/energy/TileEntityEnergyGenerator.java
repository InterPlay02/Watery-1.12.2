package com.interplay.watery.energy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

@SuppressWarnings("unused")
public class TileEntityEnergyGenerator extends TileEntity implements ITickable
{
	public ItemStackHandler handler = new ItemStackHandler(3);
	private ModEnergyStorage storage = new ModEnergyStorage(720000, 0, 200);
	public int energy = storage.getEnergyStored();
	private String CustomName;
	public int CookTime;
	
	@Override
	public void update()
	{
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)))
        {
            if(energy < storage.getMaxEnergyStored())
            {
            	CookTime++;
            	energy += getFuelValue(handler.getStackInSlot(0));
            
            	if(CookTime == 25)
            	{
            		handler.getStackInSlot(0).shrink(1);            		
            		CookTime = 0;
            	}
            }
        } 
	}
	
	public void consumeEnergy(int amount) {
        energy -= amount;
    }
   
    public int getFuelValueFromGenerator()
    {
        return energy;
    }
 
    public boolean isItemFuel(ItemStack stack)
    {
        return getFuelValue(stack) > 0;
    }
   
    private int getFuelValue(ItemStack stack)
    {
        if(stack.getItem() == Items.COAL) return 1600;
        else if(stack.getItem() == Items.BLAZE_ROD || stack.getItem() == Items.LAVA_BUCKET) return 2400;
        else if(stack.getItem() == Items.STICK) return 200;
        else if(stack.getItem() == Items.WOODEN_AXE || stack.getItem() == Items.WOODEN_HOE || stack.getItem() == Items.WOODEN_PICKAXE || stack.getItem() == Items.WOODEN_SHOVEL || stack.getItem() == Items.WOODEN_SWORD) return 400;
        else return 0;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
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
        super.writeToNBT(compound);
        compound.setTag("Inventory", this.handler.serializeNBT());
        compound.setInteger("CookTime", this.CookTime);
        compound.setInteger("GuiEnergy1", this.energy);
        compound.setString("CustomName", getDisplayName().toString());
        this.storage.writeToNBT(compound);
        return compound;
    }
   
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.CookTime = compound.getInteger("CookTime");
        this.energy = compound.getInteger("GuiEnergy");
        this.CustomName = compound.getString("CustomName");
        this.storage.readFromNBT(compound);
    }
   
    @Override
    public ITextComponent getDisplayName()
    {
        return new TextComponentTranslation("tile.energy_generator.name");
    }
   
    public int getEnergyStored()
    {
        return this.energy;
    }
   
    public int getMaxEnergyStored()
    {
        return this.storage.getMaxEnergyStored();
    }
   
    public int getField(int id)
    {
        switch(id)
        {
        case 0:
            return this.energy;
        case 1:
            return this.CookTime;
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
            this.CookTime = value;
        }
    }
   
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
}
