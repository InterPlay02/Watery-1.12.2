package com.interplay.watery.energy;

/*
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;*/
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.energy.IEnergyStorage;

public abstract class EnergyStorage<T extends IEnergyStorage> implements IStorage<IEnergy>
{
	/*
	@Override
	public NBTBase writeNBT(Capability<IEnergy> capability, IEnergy instance, EnumFacing side)
	{
		return new NBTTagInt(instance.getWEnergy());
	}

	@Override
	public void readNBT(Capability<IEnergy> capability, IEnergy instance, EnumFacing side, NBTBase nbt)
	{
		instance.set(((NBTPrimitive) nbt).getInt());
	}*/
}
