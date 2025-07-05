package net.ambersand.lottablocks.registry;

import com.google.common.collect.ImmutableMap;
import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.items.ModItems;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.ambersand.lottablocks.registry.blocks.ModBlocks;
import net.ambersand.lottablocks.registry.misc.ModCreativeModeTabs;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.level.block.*;
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
        return Optional.ofNullable(GLOW_INK_BLOCKS.get(blockState.getBlock())).map((block) -> block.getStateWithProperties(blockState));
    }

    private static Optional<BlockState> getScrapingBlocks(BlockState blockState) {
        return Optional.ofNullable(SCRAPING_BLOCKS.get(blockState.getBlock())).map((block) -> block.getStateWithProperties(blockState));
    }

    private static void executeBlockEvents(World level, BlockPos blockPos, BlockState newBlockState, PlayerEntity player, ItemStack itemStack, SoundEvent soundEvent, int levelEvent) {

        // Sets the block to a new block and plays a sound

        level.setBlockState(blockPos, newBlockState);
        level.playSound(null, blockPos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
        level.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(player, newBlockState));
        level.syncWorldEvent(player, levelEvent, blockPos, 1);

        // Awards the player stats and criteria triggers

        player.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
        if (player instanceof ServerPlayerEntity serverPlayer) Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
    }

    // endregion

    // region Misc

    public static final Identifier LUIGITE_PACKET_ID = LottaBlocks.id("luigite_packet");

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
            ItemStack heldItem = player.getStackInHand(interactionHand);

            Optional<BlockState> glowInkSacBlocks = getGlowInkSacBlocks(blockState);
            Optional<BlockState> scrapingBlocks = getScrapingBlocks(blockState);

            if (player.getStackInHand(interactionHand).getItem() == Items.GLOW_INK_SAC && glowInkSacBlocks.isPresent()) {

                executeBlockEvents(level, blockPos, glowInkSacBlocks.get(), player, heldItem, SoundEvents.ITEM_GLOW_INK_SAC_USE, 3005);

                // If the player is not in Creative Mode, 1 Glow Ink Sac will be removed from the player's inventory

                if (!player.getAbilities().creativeMode) heldItem.decrement(1);
                return ActionResult.SUCCESS;

            } else if (player.getStackInHand(interactionHand).getItem() instanceof AxeItem && scrapingBlocks.isPresent()) {

                executeBlockEvents(level, blockPos, scrapingBlocks.get(), player, heldItem, SoundEvents.ITEM_AXE_WAX_OFF, 3004);

                // If the player is not in Creative Mode, 1 durability damage will be done to the Axe

                if (!player.isCreative()) heldItem.damage(1, player, (axe) -> axe.broadcastBreakEvent(interactionHand));
                return ActionResult.SUCCESS;

            } else {
                return ActionResult.PASS;
            }
        });

        // endregion

        System.out.println("Registering Content for " + LottaBlocks.LOGGER.getName());
    }
}