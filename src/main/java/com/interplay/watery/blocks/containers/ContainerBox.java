package com.interplay.watery.blocks.containers;

import com.interplay.watery.blocks.tileentity.TileEntityBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBox extends Container
{
	private TileEntityBox tileEntityBox;
	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

	private final int VANILLA_FIRST_SLOT_INDEX = 0;
	private final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
	private final int TE_INVENTORY_SLOT_COUNT = 9;
	
	public ContainerBox(InventoryPlayer invPlayer, TileEntityBox tileEntityBox)
	{
		this.tileEntityBox = tileEntityBox;
		final int SLOT_X_SPACING = 18;
		final int SLOT_Y_SPACING = 18;
		final int HOTBAR_XPOS = 8;
		final int HOTBAR_YPOS = 109;
		for (int x = 0; x < HOTBAR_SLOT_COUNT; x++)
		{
			int slotNumber = x;
			addSlotToContainer(new Slot(invPlayer, slotNumber, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
		}
		
		final int PLAYER_INVENTORY_XPOS = 8;
		final int PLAYER_INVENTORY_YPOS = 51;
		for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++)
		{
			for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++)
			{
				int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
				int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
				int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
				addSlotToContainer(new Slot(invPlayer, slotNumber,  xpos, ypos));
			}
		}
		
		if (TE_INVENTORY_SLOT_COUNT != tileEntityBox.getSizeInventory())
		{
			System.err.println("Mismatched slot count in ContainerBox(" + TE_INVENTORY_SLOT_COUNT + ") and TileInventory (" + tileEntityBox.getSizeInventory()+")");
		}
		final int TILE_INVENTORY_XPOS = 8;
		final int TILE_INVENTORY_YPOS = 20;
		for (int x = 0; x < TE_INVENTORY_SLOT_COUNT; x++)
		{
			int slotNumber = x;
			addSlotToContainer(new Slot(tileEntityBox, slotNumber, TILE_INVENTORY_XPOS + SLOT_X_SPACING * x, TILE_INVENTORY_YPOS));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntityBox.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex)
	{
		Slot sourceSlot = (Slot)inventorySlots.get(sourceSlotIndex);
		if (sourceSlot == null || !sourceSlot.getHasStack()) return ItemStack.EMPTY;
		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();
		if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT)
		{
			if (!mergeItemStack(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)){
				return ItemStack.EMPTY;
			}
		}
		else if (sourceSlotIndex >= TE_INVENTORY_FIRST_SLOT_INDEX && sourceSlotIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT)
		{
			if (!mergeItemStack(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
				return ItemStack.EMPTY;
			}
		}
		else
		{
			System.err.print("Invalid slotIndex:" + sourceSlotIndex);
			return ItemStack.EMPTY;
		}
		
		if (sourceStack.getCount() == 0)
		{
			sourceSlot.putStack(ItemStack.EMPTY);
		}
		else
		{
			sourceSlot.onSlotChanged();
		}

		sourceSlot.onTake(player, sourceStack);
		return copyOfSourceStack;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
		super.onContainerClosed(playerIn);
		this.tileEntityBox.closeInventory(playerIn);
	}
}
