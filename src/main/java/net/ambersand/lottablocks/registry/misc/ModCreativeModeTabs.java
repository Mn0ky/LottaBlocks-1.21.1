package net.ambersand.lottablocks.registry.misc;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ambersand.lottablocks.registry.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;

public class ModCreativeModeTabs {

    @SuppressWarnings("all")
    public static void registerCreativeTabs() {

        // region Building Blocks Tab

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {

            entries.addAfter(Blocks.BAMBOO_MOSAIC, ModBlocks.BAMBOO_WEAVE);
            entries.addAfter(Blocks.BAMBOO_MOSAIC_STAIRS, ModBlocks.BAMBOO_WEAVE_STAIRS);
            entries.addAfter(Blocks.BAMBOO_MOSAIC_SLAB, ModBlocks.BAMBOO_WEAVE_SLAB);

            entries.addBefore(Blocks.STONE, Blocks.DIRT, ModBlocks.DIRT_BRICKS, ModBlocks.DIRT_BRICK_STAIRS, ModBlocks.DIRT_BRICK_SLAB, ModBlocks.DIRT_BRICK_WALL);

            entries.addAfter(Blocks.MOSSY_COBBLESTONE_WALL, ModBlocks.COBBLESTONE_BRICKS, ModBlocks.COBBLESTONE_BRICK_STAIRS, ModBlocks.COBBLESTONE_BRICK_SLAB, ModBlocks.COBBLESTONE_BRICK_WALL);

            entries.addAfter(Blocks.CHISELED_STONE_BRICKS, ModBlocks.STONE_PILLAR);
            entries.addAfter(Blocks.MOSSY_STONE_BRICK_WALL, ModBlocks.STONE_TILES, ModBlocks.STONE_TILE_STAIRS, ModBlocks.STONE_TILE_SLAB, ModBlocks.STONE_TILE_WALL);

            entries.addAfter(ModBlocks.STONE_TILE_WALL, Blocks.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_BRICKS, ModBlocks.DRIPSTONE_BRICK_STAIRS, ModBlocks.DRIPSTONE_BRICK_SLAB,
            ModBlocks.DRIPSTONE_BRICK_WALL, ModBlocks.DRIPSTONE_SHINGLES, ModBlocks.DRIPSTONE_SHINGLE_STAIRS, ModBlocks.DRIPSTONE_SHINGLE_SLAB, ModBlocks.DRIPSTONE_SHINGLE_WALL);

            entries.addBefore(Blocks.DIORITE, ModBlocks.POLISHED_GRANITE_BRICKS, ModBlocks.POLISHED_GRANITE_BRICK_STAIRS, ModBlocks.POLISHED_GRANITE_BRICK_SLAB, ModBlocks.POLISHED_GRANITE_BRICK_WALL);

            entries.addBefore(Blocks.ANDESITE, ModBlocks.POLISHED_DIORITE_BRICKS, ModBlocks.POLISHED_DIORITE_BRICK_STAIRS, ModBlocks.POLISHED_DIORITE_BRICK_SLAB, ModBlocks.POLISHED_DIORITE_BRICK_WALL);

            entries.addBefore(Blocks.DEEPSLATE, ModBlocks.POLISHED_ANDESITE_BRICKS, ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS, ModBlocks.POLISHED_ANDESITE_BRICK_SLAB, ModBlocks.POLISHED_ANDESITE_BRICK_WALL,
            Blocks.TUFF, ModBlocks.TUFF_BRICKS, ModBlocks.TUFF_BRICK_STAIRS, ModBlocks.TUFF_BRICK_SLAB, ModBlocks.TUFF_BRICK_WALL);

            entries.addAfter(Blocks.CHISELED_DEEPSLATE, ModBlocks.DEEPSLATE_PILLAR);

            entries.addAfter(Blocks.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_RED_NETHER_BRICKS, ModBlocks.BLUE_NETHER_BRICKS, ModBlocks.BLUE_NETHER_BRICK_STAIRS,
            ModBlocks.BLUE_NETHER_BRICK_SLAB, ModBlocks.BLUE_NETHER_BRICK_WALL, ModBlocks.CHISELED_BLUE_NETHER_BRICKS);

            entries.addAfter(Blocks.POLISHED_BASALT, ModBlocks.CHISELED_POLISHED_BASALT, ModBlocks.POLISHED_BASALT_BRICKS, ModBlocks.POLISHED_BASALT_BRICK_STAIRS, ModBlocks.POLISHED_BASALT_BRICK_SLAB,
            ModBlocks.POLISHED_BASALT_BRICK_WALL, ModBlocks.POLISHED_BASALT_TILES, ModBlocks.POLISHED_BASALT_TILE_STAIRS, ModBlocks.POLISHED_BASALT_TILE_SLAB, ModBlocks.POLISHED_BASALT_TILE_WALL);

            entries.addAfter(Blocks.CHISELED_POLISHED_BLACKSTONE, ModBlocks.POLISHED_BLACKSTONE_PILLAR);

            entries.addAfter(Blocks.POLISHED_BLACKSTONE_BRICK_WALL, ModBlocks.POLISHED_BLACKSTONE_TILES, ModBlocks.POLISHED_BLACKSTONE_TILE_STAIRS,
            ModBlocks.POLISHED_BLACKSTONE_TILE_SLAB, ModBlocks.POLISHED_BLACKSTONE_TILE_WALL);

            entries.addAfter(ModBlocks.POLISHED_BLACKSTONE_TILE_WALL, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_PILLAR, ModBlocks.OBSIDIAN_BRICKS,
            ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.OBSIDIAN_BRICK_WALL);

            entries.addAfter(Blocks.CHAIN, ModBlocks.CAST_IRON_BLOCK, ModBlocks.CUT_CAST_IRON, ModBlocks.CUT_CAST_IRON_STAIRS, ModBlocks.CUT_CAST_IRON_SLAB);

            entries.addAfter(Blocks.GOLD_BLOCK, ModBlocks.CHISELED_GOLD_BLOCK, ModBlocks.GOLD_PILLAR, ModBlocks.CUT_GOLD, ModBlocks.CUT_GOLD_STAIRS, ModBlocks.CUT_GOLD_SLAB);

            entries.addAfter(Blocks.NETHERITE_BLOCK, ModBlocks.CUT_NETHERITE, ModBlocks.CUT_NETHERITE_STAIRS, ModBlocks.CUT_NETHERITE_SLAB);

            entries.addBefore(Blocks.AMETHYST_BLOCK, Blocks.CALCITE, ModBlocks.CALCITE_BRICKS, ModBlocks.CALCITE_BRICK_STAIRS, ModBlocks.CALCITE_BRICK_SLAB, ModBlocks.CALCITE_BRICK_WALL);

            entries.addAfter(Blocks.AMETHYST_BLOCK, ModBlocks.CHISELED_AMETHYST, ModBlocks.AMETHYST_PILLAR, ModBlocks.AMETHYST_BRICKS,
            ModBlocks.AMETHYST_BRICK_STAIRS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICK_WALL);

            entries.addAfter(Blocks.DARK_PRISMARINE_SLAB, Blocks.PACKED_ICE, Blocks.BLUE_ICE, ModBlocks.PACKED_ICE_BRICKS, ModBlocks.PACKED_ICE_BRICK_STAIRS, ModBlocks.PACKED_ICE_BRICK_SLAB, ModBlocks.PACKED_ICE_BRICK_WALL);
        });

        // endregion

        // region Colored Blocks Tab

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.GLASS, ModBlocks.GLOW_GLASS, ModBlocks.SOUL_GLASS, ModBlocks.REINFORCED_GLASS);
        });

        // endregion

        // region Natural Blocks Tab

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.MOSS_CARPET, ModBlocks.WALL_MOSS);
            entries.addAfter(Blocks.JACK_O_LANTERN, ModBlocks.JACK_O_SOULS);
            entries.addAfter(Blocks.COBWEB, ModBlocks.WALL_WEB);
        });

        // endregion

        // region Functional Blocks Tab

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {

            entries.addAfter(Blocks.SOUL_LANTERN, ModBlocks.LANTERN_BLOCK, ModBlocks.SOUL_LANTERN_BLOCK, ModBlocks.AMETHYST_FLOODLIGHT);
            entries.addAfter(Blocks.REDSTONE_LAMP, ModBlocks.LAVA_LAMP);
            entries.addAfter(Blocks.SHROOMLIGHT, ModBlocks.HONEYLAMP);
            entries.addAfter(Blocks.PEARLESCENT_FROGLIGHT, ModBlocks.BLOOMING_PAPER_LANTERN, ModBlocks.SUNRISE_PAPER_LANTERN, ModBlocks.TWILIGHT_PAPER_LANTERN);
        });

        // endregion
    }
}