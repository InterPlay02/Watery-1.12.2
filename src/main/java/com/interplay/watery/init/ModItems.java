package com.interplay.watery.init;

import java.util.ArrayList;
import java.util.List;

import com.interplay.watery.Main;
import com.interplay.watery.items.ItemBase;
import com.interplay.watery.items.OxygenMask;
import com.interplay.watery.items.OxygenTank;
import com.interplay.watery.items.armor.ArmorBase;
import com.interplay.watery.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materiais das ferramentas e armaduras (O nome da textura da armadura precisa ser o mesmo que há em Reference.MOD_ID + ":nome_da_textura")
	public static final ArmorMaterial ARMOR_MATERIAL_RUBBER = EnumHelper.addArmorMaterial("armor_material_rubber", Reference.MOD_ID + ":rubber", 15, new int[] {2, 1, 1, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	public static final ArmorMaterial OXYGEN_MASK = EnumHelper.addArmorMaterial("oxygen_mask", Reference.MOD_ID + ":oxygen_mask", 15, new int[] {2, 1, 1, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	public static final ArmorMaterial OXYGEN_TANK = EnumHelper.addArmorMaterial("oxygen_tank", Reference.MOD_ID + ":oxygen_tank", 15, new int[] {2, 1, 1, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
		
	//Recursos minerais
	public static final Item CEMENT = new ItemBase("cement");
	public static final Item CONCRETE = new ItemBase("concrete");
	public static final Item LIMESTONE = new ItemBase("limestone");
	public static final Item IRON_DUST = new ItemBase("iron_dust");
	
	//Roupa de Borracha
	public static final Item MASK = new OxygenMask("mask", Main.tabwatery, OXYGEN_MASK, EntityEquipmentSlot.HEAD);
	public static final Item OVERALLS = new OxygenTank("overalls", Main.tabwatery, OXYGEN_TANK, EntityEquipmentSlot.CHEST);
	public static final Item RUBBER_BOOTS = new ArmorBase("rubber_boots", ARMOR_MATERIAL_RUBBER, 1, EntityEquipmentSlot.FEET);
	
	//Sucos                   Nome do suco                  Nome nos arquivos / Se animais podem comer       Efeito de poção (tipo)  Duração  É de beacon? Exibe Partículas?
	//public static final Item APPLE_JUICE = new FoodEffectBase("apple_juice", 7, 5.0f, false, new PotionEffect(MobEffects.SATURATION, (10*20), 0, false, true)); <- Comida com efeito especial
	//public static final Item APPLE_JUICE = new FoodBase("apple_juice", 7, 5.0f, false);
	//public static final Item APPLE_JUICE = new JuiceBase("apple_juice", 7, 5.0f);
	
	//Itens
	
}









