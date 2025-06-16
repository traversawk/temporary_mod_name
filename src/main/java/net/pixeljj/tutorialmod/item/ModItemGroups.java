package net.pixeljj.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pixeljj.tutorialmod.TutorialMod;
import net.pixeljj.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CRAB_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "crab_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CRAB))
                    .displayName(Text.translatable("itemgroup.tutorialmod.crab_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CRAB);
                        entries.add(ModBlocks.CRAB_BLOCK);
                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
