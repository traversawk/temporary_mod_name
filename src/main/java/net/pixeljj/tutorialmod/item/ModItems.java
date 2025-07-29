package net.pixeljj.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pixeljj.tutorialmod.TutorialMod;
import net.pixeljj.tutorialmod.item.custom.CrabItem;

public class ModItems {
    public static final Item CRAB = registerItem("crab", new Item(new Item.Settings().food(ModFoodComponents.CRAB)));
    public static final Item CRAB_WAND = registerItem("crab_wand", new CrabItem(new Item.Settings().maxDamage(32)));
    public static final Item CRAB_LEG = registerItem("crab_leg", new Item(new Item.Settings().food(ModFoodComponents.CRAB_LEG)));
    public static final Item PKMN_CHARCOAL = registerItem("pkmn_charcoal", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
