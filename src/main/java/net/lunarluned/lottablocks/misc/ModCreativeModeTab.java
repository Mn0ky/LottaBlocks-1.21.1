package net.lunarluned.lottablocks.misc;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lunarluned.lottablocks.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ModCreativeModeTab {

    @SuppressWarnings("all")
    public static void registerCreativeTabs() {
        // Building Blocks
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BRICKS, ModBlocks.AMETHYST_BRICK_STAIRS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICK_WALL, ModBlocks.CHISELED_AMETHYST, ModBlocks.AMETHYST_FLOODLIGHT, ModBlocks.AMETHYST_PILLAR);
            entries.addAfter(Blocks.BAMBOO_BUTTON, ModBlocks.BAMBOO_WEAVE, ModBlocks.BAMBOO_WEAVE_STAIRS, ModBlocks.BAMBOO_WEAVE_SLAB);
            entries.addAfter(Blocks.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_RED_NETHER_BRICKS, ModBlocks.BLUE_NETHER_BRICKS, ModBlocks.BLUE_NETHER_BRICK_STAIRS, ModBlocks.BLUE_NETHER_BRICK_SLAB, ModBlocks.BLUE_NETHER_BRICK_WALL, ModBlocks.CHISELED_BLUE_NETHER_BRICKS);
            entries.addAfter(Blocks.POLISHED_DIORITE_SLAB, Blocks.CALCITE, ModBlocks.CALCITE_BRICKS, ModBlocks.CALCITE_BRICK_STAIRS, ModBlocks.CALCITE_BRICK_SLAB, ModBlocks.CALCITE_BRICK_WALL);
            entries.addAfter(Blocks.POLISHED_ANDESITE_SLAB, Blocks.TUFF, ModBlocks.TUFF_BRICKS, ModBlocks.TUFF_BRICK_STAIRS, ModBlocks.TUFF_BRICK_SLAB, ModBlocks.TUFF_BRICK_WALL);
            entries.addAfter(Blocks.CHAIN, ModBlocks.CAST_IRON_BLOCK, ModBlocks.CUT_CAST_IRON, ModBlocks.CUT_CAST_IRON_STAIRS, ModBlocks.CUT_CAST_IRON_SLAB);
            entries.addAfter(Blocks.GOLD_BLOCK, ModBlocks.GOLD_PILLAR, ModBlocks.CUT_GOLD, ModBlocks.CUT_GOLD_STAIRS, ModBlocks.CUT_GOLD_SLAB, ModBlocks.CHISELED_GOLD_BLOCK);
            entries.addAfter(Blocks.POLISHED_BASALT, ModBlocks.CHISELED_POLISHED_BASALT, ModBlocks.POLISHED_BASALT_BRICKS, ModBlocks.POLISHED_BASALT_BRICK_STAIRS, ModBlocks.POLISHED_BASALT_BRICK_SLAB, ModBlocks.POLISHED_BASALT_BRICK_WALL, ModBlocks.POLISHED_BASALT_TILES, ModBlocks.POLISHED_BASALT_TILE_STAIRS, ModBlocks.POLISHED_BASALT_TILE_SLAB, ModBlocks.POLISHED_BASALT_TILE_WALL);
            entries.addAfter(Blocks.DEEPSLATE, ModBlocks.DEEPSLATE_PILLAR);
            entries.addAfter(Blocks.POLISHED_BLACKSTONE_BUTTON, ModBlocks.POLISHED_BLACKSTONE_PILLAR, ModBlocks.POLISHED_BLACKSTONE_TILES, ModBlocks.POLISHED_BLACKSTONE_TILE_STAIRS, ModBlocks.POLISHED_BLACKSTONE_TILE_SLAB, ModBlocks.POLISHED_BLACKSTONE_TILE_WALL);
            entries.addAfter(Blocks.COBBLESTONE_WALL, ModBlocks.COBBLESTONE_BRICKS, ModBlocks.COBBLESTONE_BRICK_STAIRS, ModBlocks.COBBLESTONE_BRICK_SLAB, ModBlocks.COBBLESTONE_BRICK_WALL);
            entries.addAfter(Blocks.NETHERITE_BLOCK, ModBlocks.CUT_NETHERITE, ModBlocks.CUT_NETHERITE_STAIRS, ModBlocks.CUT_NETHERITE_SLAB);
            entries.addAfter(Blocks.WARPED_BUTTON, Blocks.DIRT, ModBlocks.DIRT_BRICKS, ModBlocks.DIRT_BRICK_STAIRS, ModBlocks.DIRT_BRICK_SLAB, ModBlocks.DIRT_BRICK_WALL);
            entries.addAfter(Blocks.POLISHED_BLACKSTONE_BRICK_WALL, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_PILLAR, ModBlocks.OBSIDIAN_BRICKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.OBSIDIAN_BRICK_WALL);
            entries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, Blocks.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_BRICKS, ModBlocks.DRIPSTONE_BRICK_STAIRS, ModBlocks.DRIPSTONE_BRICK_SLAB, ModBlocks.DRIPSTONE_SHINGLES, ModBlocks.DRIPSTONE_SHINGLE_STAIRS, ModBlocks.DRIPSTONE_SHINGLE_SLAB);
            entries.addAfter(Blocks.POLISHED_ANDESITE, ModBlocks.POLISHED_ANDESITE_BRICKS, ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS, ModBlocks.POLISHED_ANDESITE_BRICK_SLAB, ModBlocks.POLISHED_ANDESITE_BRICK_WALL);
            entries.addAfter(Blocks.POLISHED_DIORITE, ModBlocks.POLISHED_DIORITE_BRICKS, ModBlocks.POLISHED_DIORITE_BRICK_STAIRS, ModBlocks.POLISHED_DIORITE_BRICK_SLAB, ModBlocks.POLISHED_DIORITE_BRICK_WALL);
            entries.addAfter(Blocks.POLISHED_GRANITE, ModBlocks.POLISHED_GRANITE_BRICKS, ModBlocks.POLISHED_GRANITE_BRICK_STAIRS, ModBlocks.POLISHED_GRANITE_BRICK_SLAB, ModBlocks.POLISHED_GRANITE_BRICK_WALL);
            entries.addAfter(Blocks.STONE_BUTTON, ModBlocks.STONE_PILLAR, ModBlocks.STONE_TILES, ModBlocks.STONE_TILE_STAIRS, ModBlocks.STONE_TILE_SLAB, ModBlocks.STONE_TILE_WALL);
        });
        // Functional Blocks
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addBefore(Blocks.OCHRE_FROGLIGHT, ModBlocks.HONEYLAMP);
            entries.addBefore(Blocks.GLOWSTONE, ModBlocks.LAVA_LAMP);
            entries.addAfter(Blocks.LANTERN, ModBlocks.LANTERN_BLOCK);
            entries.addAfter(Blocks.SOUL_LANTERN, ModBlocks.SOUL_LANTERN_BLOCK);
            entries.addAfter(Blocks.PEARLESCENT_FROGLIGHT, ModBlocks.BLOOMING_PAPER_LANTERN, ModBlocks.SUNRISE_PAPER_LANTERN, ModBlocks.TWILIGHT_PAPER_LANTERN);
    });
        // Colored Blocks
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.GLASS, ModBlocks.GLOW_GLASS, ModBlocks.REINFORCED_GLASS, ModBlocks.SOUL_GLASS);
        });
        // Natural Blocks
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addBefore(Blocks.GLOW_LICHEN, ModBlocks.WALL_MOSS, ModBlocks.WALL_WEB);
            entries.addAfter(Blocks.JACK_O_LANTERN, ModBlocks.JACK_O_SOULS);
        });
    }
}
