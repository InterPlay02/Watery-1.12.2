package com.interplay.watery.blocks.containers;

import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerEnergyGenerator extends Container
{
	private final TileEntityEnergyGenerator inventory;
    private int energy, cookTime;
   
    public ContainerEnergyGenerator(InventoryPlayer player, TileEntityEnergyGenerator inventory)
    {
        this.inventory = inventory;
       
        this.addSlotToContainer(new Slot(inventory, 0, 63, 30));
        this.addSlotToContainer(new Slot(inventory, 1, 37, 19));
        this.addSlotToContainer(new Slot(inventory, 2, 37, 51));
       
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
            }
        }
       
        for(int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }
   
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.inventory.isUsableByPlayer(playerIn);
    }
   
    @Override
    public void updateProgressBar(int id, int data)
    {
        this.inventory.setField(id, data);
    }
   
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
       
        for(int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);
            if(this.energy != this.inventory.getField(0)) listener.sendWindowProperty(this, 0, this.inventory.getField(0));
            if(this.cookTime != this.inventory.getField(1)) listener.sendWindowProperty(this, 1, this.inventory.getField(1));
        }
       
        this.energy = this.inventory.getField(0);
        this.cookTime = this.inventory.getField(1);
    }
   
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
       
        if(slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();
           
            if(index >= 0 && index < 27) {
                if(!this.mergeItemStack(stack1, 27, 36, false)) return ItemStack.EMPTY;
            }
            else if(index >= 27 && index < 36) {
                if(!this.mergeItemStack(stack1, 0, 27, false)) return ItemStack.EMPTY;
            }
            else if(!this.mergeItemStack(stack1, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
           
            if(stack1.isEmpty()) slot.putStack(ItemStack.EMPTY);
            else slot.onSlotChanged();
           
            if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
       
        return stack;
    }
}
