package net.ambersand.lottablocks.registry;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.ambersand.lottablocks.registry.blocks.ModBlocks;
import net.ambersand.lottablocks.registry.misc.ModCreativeModeTabs;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Objects;

public class LottaBlocksRegistry {

    private static final ImmutableMap<Block, Block> GLOW_INK_SAC_APPLYING = ImmutableMap.<Block, Block>builder()
        .put(Blocks.GLASS, ModBlocks.GLOW_GLASS)
        .build();

    private static final ImmutableMap<Block, Block> SCRAPING = ImmutableMap.<Block, Block>builder()
        .put(ModBlocks.GLOW_GLASS, Blocks.GLASS)
        .build();

    public static void registerAll() {

        // region Registry

        ModBlocks.registerModBlocks();
        ModSoundEvents.registerSounds();
        ModCreativeModeTabs.registerCreativeTabs();

        // endregion

        // region Flammable Blocks

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE_STAIRS, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE_SLAB, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SUNRISE_PAPER_LANTERN, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TWILIGHT_PAPER_LANTERN, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLOOMING_PAPER_LANTERN, 60, 20);

        // endregion

        // region Interaction Events

        UseBlockCallback.EVENT.register((player, level, hand, hitresult) -> {

            var blockPos = hitresult.getBlockPos();
            var block = level.getBlockState(blockPos);
            ItemStack heldItem = player.getItemInHand(hand);

            if (player.getItemInHand(hand).getItem() == Items.GLOW_INK_SAC && GLOW_INK_SAC_APPLYING.get(block.getBlock()) != null) {

                // region Applying Glow Ink Sacs to Glass

                // Sets the Glass Block to Glow Glass

                level.setBlockAndUpdate(blockPos, Objects.requireNonNull(GLOW_INK_SAC_APPLYING.get(block.getBlock())).defaultBlockState());

                // Plays a sound and particles

                level.playSound(null, blockPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1F, 0.8F);
                level.levelEvent(player, 3005, blockPos, 1);

                // Awards the player stats and criteria triggers

                player.awardStat(Stats.ITEM_USED.get(heldItem.getItem()));

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, heldItem);
                }

                // If the player is not in Creative Mode, 1 Glow Ink Sac will be removed from the player's inventory

                if (!player.getAbilities().instabuild) {
                    heldItem.shrink(1);
                }

                return InteractionResult.SUCCESS;

                // endregion

            } else if (player.getItemInHand(hand).getItem() instanceof AxeItem && SCRAPING.get(block.getBlock()) != null) {

                // region Scraping Glow Glass Back Into Glass

                // Sets the Glow Glass back into Glass

                level.setBlockAndUpdate(blockPos, Objects.requireNonNull(SCRAPING.get(block.getBlock())).defaultBlockState());

                // Plays a sound and particles

                level.playSound(null, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1F, 1F);
                level.levelEvent(player, 3004, blockPos, 1);

                // Awards the player stats and criteria triggers

                player.awardStat(Stats.ITEM_USED.get(heldItem.getItem()));

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, heldItem);
                }

                // If the player is not in Creative Mode, 1 durability damage will be done to the Axe

                if (!player.isCreative()) {
                    heldItem.hurtAndBreak(1, player, (axe) -> axe.broadcastBreakEvent(hand));
                }

                return InteractionResult.SUCCESS;

                // endregion

            } else {
                return InteractionResult.PASS;
            }
        });

        // endregion

        System.out.println("Registering Content for Lotta Blocks");
    }
}