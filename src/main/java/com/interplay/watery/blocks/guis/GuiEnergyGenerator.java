package com.interplay.watery.blocks.guis;

import com.interplay.watery.blocks.containers.ContainerEnergyGenerator;
import com.interplay.watery.blocks.tileentity.TileEntityEnergyGenerator;
import com.interplay.watery.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEnergyGenerator extends GuiContainer
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/glowstone_generator.png");
	private final InventoryPlayer player;
	private final TileEntityEnergyGenerator tileentity;
	
	public GuiEnergyGenerator(InventoryPlayer player, TileEntityEnergyGenerator tileentity) 
	{
		super(new ContainerEnergyGenerator(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored()), 115, 72, 4210752);
		//valores de x e y para o tamanho da barrinha de energia.   ->                    /\   /\
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 113, this.guiTop + 32, 176, 14, l + 1, 16);
		
		int k = this.getEnergyStoredScaled(75); //tamanho da barrinha de energia na Gui: 75.
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 32, 16, 76 - k);
		//Essa acima designa o local onde ser� desenhada a barrinha de energia na Gui. Este "76 - k" desenha a barrinha subindo.
	}
	
	//c�lculos da energia armazenada.
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getEnergyStored(); //coleta quanta energia h� armazenada.
		int j = this.tileentity.getMaxEnergyStored(); //coleta o m�ximo de energia armazenada.
		return i != 0 && j != 0 ? i * pixels / j : 0; //multiplica pelo tamanho da barrinha na gui e depois divide pelo m�ximo.
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.cookTime;
		return i != 0 ? i * pixels / 25 : 0;
	}
}
