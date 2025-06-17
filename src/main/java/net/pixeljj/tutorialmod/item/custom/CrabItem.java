package net.pixeljj.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.pixeljj.tutorialmod.block.ModBlocks;

import java.util.Map;

public class CrabItem extends Item {
    private static final Map<Block, Block> CRAB_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, ModBlocks.CRAB_BLOCK,
                    Blocks.DIRT, ModBlocks.CRAB_BLOCK,
                    Blocks.STONE, ModBlocks.CRAB_BLOCK
            );
    public CrabItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CRAB_MAP.containsKey(clickedBlock)){
            if (!world.isClient()){
                world.setBlockState(context.getBlockPos(), CRAB_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        } else {
            if (!world.isClient()){
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
