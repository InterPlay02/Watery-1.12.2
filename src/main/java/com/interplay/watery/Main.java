package com.interplay.watery;

import com.interplay.watery.creativetabs.TabWatery;
import com.interplay.watery.init.ModSmeltingRecipes;
import com.interplay.watery.proxy.CommonProxy;
import com.interplay.watery.util.Reference;
import com.interplay.watery.world.ModWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Main {
	
	//Aba do Criativo "Main.tabwatery".
	public static final CreativeTabs tabwatery = new TabWatery("tabwatery");

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		//Ativar gera��o de mundo aqui:
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		//Ativar receitas de fornalha aqui:
		ModSmeltingRecipes.init();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}