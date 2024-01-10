package net.ambersand.lottablocks.registry;

import com.google.common.collect.ImmutableMap;
import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.items.ModItems;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.ambersand.lottablocks.registry.blocks.ModBlocks;
import net.ambersand.lottablocks.registry.misc.ModCreativeModeTabs;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import java.util.Optional;

public class LottaBlocksRegistry {

    // region Block Changing Events

    private static final ImmutableMap<Block, Block> GLOW_INK_BLOCKS = ImmutableMap.<Block, Block>builder()
        .put(Blocks.GLASS, ModBlocks.GLOW_GLASS)
        .put(Blocks.GLASS_PANE, ModBlocks.GLOW_GLASS_PANE)
        .build();

    private static final ImmutableMap<Block, Block> SCRAPING_BLOCKS = ImmutableMap.<Block, Block>builder()
        .put(ModBlocks.GLOW_GLASS, Blocks.GLASS)
        .put(ModBlocks.GLOW_GLASS_PANE, Blocks.GLASS_PANE)
        .build();

    private static Optional<BlockState> getGlowInkSacBlocks(BlockState blockState) {
        return Optional.ofNullable(GLOW_INK_BLOCKS.get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));
    }

    private static Optional<BlockState> getScrapingBlocks(BlockState blockState) {
        return Optional.ofNullable(SCRAPING_BLOCKS.get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));
    }

    private static void executeBlockEvents(Level level, BlockPos blockPos, BlockState newBlockState, Player player, ItemStack itemStack, SoundEvent soundEvent, int levelEvent) {

        // Sets the block to a new block and plays a sound

        level.setBlockAndUpdate(blockPos, newBlockState);
        level.playSound(null, blockPos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newBlockState));
        level.levelEvent(player, levelEvent, blockPos, 1);

        // Awards the player stats and criteria triggers

        player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));

        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
        }
    }

    // endregion

    // region Misc

    public static final ResourceLocation LUIGITE_PACKET_ID = LottaBlocks.id("luigite_packet");

    // endregion

    public static void registerAll() {

        // region Registry

        ModItems.registerModItems();
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

        UseBlockCallback.EVENT.register((player, level, interactionHand, hitResult) -> {

            BlockPos blockPos = hitResult.getBlockPos();
            BlockState blockState = level.getBlockState(blockPos);
            ItemStack heldItem = player.getItemInHand(interactionHand);

            Optional<BlockState> glowInkSacBlocks = getGlowInkSacBlocks(blockState);
            Optional<BlockState> scrapingBlocks = getScrapingBlocks(blockState);

            if (player.getItemInHand(interactionHand).getItem() == Items.GLOW_INK_SAC && glowInkSacBlocks.isPresent()) {

                executeBlockEvents(level, blockPos, glowInkSacBlocks.get(), player, heldItem, SoundEvents.GLOW_INK_SAC_USE, 3005);

                // If the player is not in Creative Mode, 1 Glow Ink Sac will be removed from the player's inventory

                if (!player.getAbilities().instabuild) {
                    heldItem.shrink(1);
                }

                return InteractionResult.SUCCESS;

            } else if (player.getItemInHand(interactionHand).getItem() instanceof AxeItem && scrapingBlocks.isPresent()) {

                executeBlockEvents(level, blockPos, scrapingBlocks.get(), player, heldItem, SoundEvents.AXE_WAX_OFF, 3004);

                // If the player is not in Creative Mode, 1 durability damage will be done to the Axe

                if (!player.isCreative()) {
                    heldItem.hurtAndBreak(1, player, (axe) -> axe.broadcastBreakEvent(interactionHand));
                }

                return InteractionResult.SUCCESS;

            } else {
                return InteractionResult.PASS;
            }
        });

        // endregion

        System.out.println("Registering Content for " + LottaBlocks.LOGGER.getName());
    }
}