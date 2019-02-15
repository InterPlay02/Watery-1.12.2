package com.interplay.watery.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.energy.IEnergyStorage;

public class EnergyProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject (IEnergyStorage.class)
    public static final Capability<IEnergyStorage> ENERGY_CAP = null;
        
    private IEnergyStorage instance = ENERGY_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == ENERGY_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == ENERGY_CAP ? ENERGY_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) ENERGY_CAP.getStorage().writeNBT(ENERGY_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		ENERGY_CAP.getStorage().readNBT(ENERGY_CAP, this.instance, null, nbt);
	}

}
