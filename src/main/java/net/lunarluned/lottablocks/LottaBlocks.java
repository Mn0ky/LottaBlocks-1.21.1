package net.lunarluned.lottablocks;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.lunarluned.lottablocks.misc.ModCreativeModeTab;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.lunarluned.lottablocks.block.ModBlocks;
import net.lunarluned.lottablocks.sound.ModSoundEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

public class LottaBlocks implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final String MOD_ID = "lottablocks";

	public static final ImmutableMap<Block, Block> GLOW_INK_SAC_APPLYING = ImmutableMap.<Block, Block>builder()
			.put(Blocks.GLASS, ModBlocks.GLOW_GLASS)
			.build();

	public static final ImmutableMap<Block, Block> SCRAPING = ImmutableMap.<Block, Block>builder()
			.put(ModBlocks.GLOW_GLASS, Blocks.GLASS)
			.build();

	@Override
	public void onInitialize() {

		// Registry:

		ModBlocks.registerModBlocks();
		ModSoundEvents.registerSounds();
		ModCreativeModeTab.registerCreativeTabs();

		LOGGER.info("Thank you for downloading Lotta Blocks! :)");

		// Flammable Block Registry:

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE_STAIRS, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAMBOO_WEAVE_SLAB, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SUNRISE_PAPER_LANTERN, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TWILIGHT_PAPER_LANTERN, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLOOMING_PAPER_LANTERN, 60, 20);

		// Glow Ink Sac Applying:

		UseBlockCallback.EVENT.register((player, world, hand, hitresult) -> {
			if (player.getItemInHand(hand).getItem() == Items.GLOW_INK_SAC) {

				var pos = hitresult.getBlockPos();
				var block = world.getBlockState(pos);

				if (block.is(Blocks.GLASS)) {

					var glow = GLOW_INK_SAC_APPLYING.get(block.getBlock());
					if(glow != null) {

						// Change Block to Glowing Version

						world.setBlockAndUpdate(pos, Objects.requireNonNull(GLOW_INK_SAC_APPLYING.get(block.getBlock())).defaultBlockState());

						// Particles and Sound Event

						world.playSound(null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1f, 0.8f);
						world.levelEvent(player, 3005, pos, 1);

						// Stats and Advancements

						ItemStack heldItem = player.getItemInHand(hand);
						Item item = heldItem.getItem();
						player.awardStat(Stats.ITEM_USED.get(item));
						if (player instanceof ServerPlayer) {
							CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, heldItem);
						}

						// Remove 1 Glow Ink Sac if the player is not in Creative Mode

						if(!player.isCreative()) {
							heldItem.shrink(1);
						}

						return InteractionResult.SUCCESS;
					} else {
						return InteractionResult.PASS;
					}
				}
			} else {
				return InteractionResult.PASS;
			}

			return InteractionResult.PASS;
		});

		// Glow Glass Scraping:

		UseBlockCallback.EVENT.register((player, world, hand, hitresult) -> {
			if (player.getItemInHand(hand).getItem() instanceof AxeItem) {

				var pos = hitresult.getBlockPos();
				var block = world.getBlockState(pos);

				if (block.is(ModBlocks.GLOW_GLASS)) {

					var scrape = SCRAPING.get(block.getBlock());
					if(scrape != null) {

						// Change Block to Glowing Version

						world.setBlockAndUpdate(pos, Objects.requireNonNull(SCRAPING.get(block.getBlock())).defaultBlockState());

						// Particles and Sound Event

						world.playSound(null, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1f, 1f);
						world.levelEvent(player, 3004, pos, 1);

						// Stats and Advancements

						ItemStack heldItem = player.getItemInHand(hand);
						Item item = heldItem.getItem();
						player.awardStat(Stats.ITEM_USED.get(item));
						if (player instanceof ServerPlayer) {
							CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, heldItem);
						}

						// Damages the Axe if the player is not in Creative Mode

						ItemStack heldStack = player.getItemInHand(hand);

						if(!player.isCreative()) {
							heldStack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
						}

						return InteractionResult.SUCCESS;
					} else {
						return InteractionResult.PASS;
					}
				}
			} else {
				return InteractionResult.PASS;
			}

			return InteractionResult.PASS;
		});
	}
}