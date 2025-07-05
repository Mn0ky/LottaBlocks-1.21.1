package net.ambersand.lottablocks.registry.blocks;

import net.ambersand.lottablocks.registry.misc.ModNoteBlockInstruments;
import net.minecraft.block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.InfestedBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.RotatedInfestedBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.world.level.block.*;
import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.*;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;

@SuppressWarnings("unused")
public class ModBlocks {

    // Block Set Types

    public static final BlockSetType CAST_IRON_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.IRON)
        .soundGroup(BlockSoundGroup.NETHERITE).register(LottaBlocks.id("cast_iron"));

    // Blocks

    // region Amethyst Blocks

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
        new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_STAIRS = registerBlock("amethyst_brick_stairs",
        new AmethystBrickStairsBlock(ModBlocks.AMETHYST_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
        new AmethystBrickSlabBlock(FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_WALL = registerBlock("amethyst_brick_wall",
        new AmethystBrickWallBlock(FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_PILLAR = registerBlock("amethyst_pillar",
        new AmethystPillarBlock(FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)));

    public static final Block CHISELED_AMETHYST = registerBlock("chiseled_amethyst",
        new AmethystBlock(FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_FLOODLIGHT = registerBlock("amethyst_floodlight",
        new AmethystFloodlightBlock(FabricBlockSettings.create().mapColor(MapColor.BLACK)
        .nonOpaque().sounds(BlockSoundGroup.LANTERN).luminance(15).strength(3.5F).pistonBehavior(PistonBehavior.DESTROY)));

    // endregion

    // region Dripstone Blocks

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_STAIRS = registerBlock("dripstone_brick_stairs",
        new StairsBlock(ModBlocks.DRIPSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_BRICK_SLAB = registerBlock("dripstone_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_BRICK_WALL = registerBlock("dripstone_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_SHINGLES = registerBlock("dripstone_shingles",
        new Block(FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_SHINGLE_STAIRS = registerBlock("dripstone_shingle_stairs",
        new StairsBlock(ModBlocks.DRIPSTONE_SHINGLES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_SHINGLES)));

    public static final Block DRIPSTONE_SHINGLE_SLAB = registerBlock("dripstone_shingle_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_SHINGLES)));

    public static final Block DRIPSTONE_SHINGLE_WALL = registerBlock("dripstone_shingle_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.DRIPSTONE_SHINGLES)));

    // endregion

    // region Dirt Blocks

    public static final Block DIRT_BRICKS = registerBlock("dirt_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));

    public static final Block DIRT_BRICK_STAIRS = registerBlock("dirt_brick_stairs",
        new StairsBlock(ModBlocks.DIRT_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.DIRT_BRICKS)));

    public static final Block DIRT_BRICK_SLAB = registerBlock("dirt_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.DIRT_BRICKS)));

    public static final Block DIRT_BRICK_WALL = registerBlock("dirt_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.DIRT_BRICKS)));

    // endregion

    // region Cobblestone Blocks

    public static final Block COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));

    public static final Block COBBLESTONE_BRICK_STAIRS = registerBlock("cobblestone_brick_stairs",
        new StairsBlock(ModBlocks.COBBLESTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.COBBLESTONE_BRICKS)));

    public static final Block COBBLESTONE_BRICK_SLAB = registerBlock("cobblestone_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.COBBLESTONE_BRICKS)));

    public static final Block COBBLESTONE_BRICK_WALL = registerBlock("cobblestone_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.COBBLESTONE_BRICKS)));

    // endregion

    // region Blackstone Blocks

    public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)));

    public static final Block POLISHED_BLACKSTONE_TILES = registerBlock("polished_blackstone_tiles",
        new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)));

    public static final Block POLISHED_BLACKSTONE_TILE_STAIRS = registerBlock("polished_blackstone_tile_stairs",
        new StairsBlock(ModBlocks.POLISHED_BLACKSTONE_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    public static final Block POLISHED_BLACKSTONE_TILE_SLAB = registerBlock("polished_blackstone_tile_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    public static final Block POLISHED_BLACKSTONE_TILE_WALL = registerBlock("polished_blackstone_tile_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    // endregion

    // region Stone Blocks

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block STONE_TILES = registerBlock("stone_tiles",
        new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block STONE_TILE_STAIRS = registerBlock("stone_tile_stairs",
        new StairsBlock(ModBlocks.STONE_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.STONE_TILES)));

    public static final Block STONE_TILE_SLAB = registerBlock("stone_tile_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.STONE_TILES)));

    public static final Block STONE_TILE_WALL = registerBlock("stone_tile_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.STONE_TILES)));

    // endregion

    // region Deepslate Blocks

    public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)));

    // endregion

    // region Calcite Blocks

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));

    public static final Block CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
        new StairsBlock(ModBlocks.CALCITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CALCITE_BRICKS)));

    public static final Block CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CALCITE_BRICKS)));

    public static final Block CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.CALCITE_BRICKS)));

    // endregion

    // region Andesite Blocks

    public static final Block POLISHED_ANDESITE_BRICKS = registerBlock("polished_andesite_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)));

    public static final Block POLISHED_ANDESITE_BRICK_STAIRS = registerBlock("polished_andesite_brick_stairs",
        new StairsBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    public static final Block POLISHED_ANDESITE_BRICK_SLAB = registerBlock("polished_andesite_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    public static final Block POLISHED_ANDESITE_BRICK_WALL = registerBlock("polished_andesite_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    // endregion

    // region Diorite Blocks

    public static final Block POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)));

    public static final Block POLISHED_DIORITE_BRICK_STAIRS = registerBlock("polished_diorite_brick_stairs",
        new StairsBlock(ModBlocks.POLISHED_DIORITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_DIORITE_BRICKS)));

    public static final Block POLISHED_DIORITE_BRICK_SLAB = registerBlock("polished_diorite_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_DIORITE_BRICKS)));

    public static final Block POLISHED_DIORITE_BRICK_WALL = registerBlock("polished_diorite_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_DIORITE_BRICKS)));

    // endregion

    // region Granite Blocks

    public static final Block POLISHED_GRANITE_BRICKS = registerBlock("polished_granite_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)));

    public static final Block POLISHED_GRANITE_BRICK_STAIRS = registerBlock("polished_granite_brick_stairs",
        new StairsBlock(ModBlocks.POLISHED_GRANITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_GRANITE_BRICKS)));

    public static final Block POLISHED_GRANITE_BRICK_SLAB = registerBlock("polished_granite_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_GRANITE_BRICKS)));

    public static final Block POLISHED_GRANITE_BRICK_WALL = registerBlock("polished_granite_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_GRANITE_BRICKS)));

    // endregion

    // region Basalt Blocks

    public static final Block POLISHED_BASALT_BRICKS = registerBlock("polished_basalt_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)));

    public static final Block POLISHED_BASALT_BRICK_STAIRS = registerBlock("polished_basalt_brick_stairs",
        new StairsBlock(ModBlocks.POLISHED_BASALT_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_BRICK_SLAB = registerBlock("polished_basalt_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_BRICK_WALL = registerBlock("polished_basalt_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_TILES = registerBlock("polished_basalt_tiles",
        new Block(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_TILE_STAIRS = registerBlock("polished_basalt_tile_stairs",
        new StairsBlock(ModBlocks.POLISHED_BASALT_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block POLISHED_BASALT_TILE_SLAB = registerBlock("polished_basalt_tile_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block POLISHED_BASALT_TILE_WALL = registerBlock("polished_basalt_tile_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block CHISELED_POLISHED_BASALT = registerBlock("chiseled_polished_basalt",
        new Block(FabricBlockSettings.copyOf(ModBlocks.POLISHED_BASALT_BRICKS)));

    // endregion

    // region Cast Iron Blocks

    public static final Block CAST_IRON_BLOCK = registerBlock("cast_iron_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
        .mapColor(MapColor.BLACK).sounds(BlockSoundGroup.NETHERITE)));

    public static final Block CUT_CAST_IRON = registerBlock("cut_cast_iron",
        new Block(FabricBlockSettings.copyOf(ModBlocks.CAST_IRON_BLOCK)));

    public static final Block CUT_CAST_IRON_STAIRS = registerBlock("cut_cast_iron_stairs",
        new StairsBlock(ModBlocks.CUT_CAST_IRON.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CUT_CAST_IRON)));

    public static final Block CUT_CAST_IRON_SLAB = registerBlock("cut_cast_iron_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_CAST_IRON)));

    public static final Block CAST_IRON_DOOR = registerBlock("cast_iron_door",
        new DoorBlock(CAST_IRON_TYPE, FabricBlockSettings.copyOf(Blocks.IRON_DOOR).mapColor(MapColor.BLACK)));

    public static final Block CAST_IRON_TRAPDOOR = registerBlock("cast_iron_trapdoor",
        new TrapdoorBlock(CAST_IRON_TYPE, FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).mapColor(MapColor.BLACK)));

    // endregion

    // region Gold Blocks

    public static final Block CHISELED_GOLD_BLOCK = registerBlock("chiseled_gold_block",
        new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block GOLD_PILLAR = registerBlock("gold_pillar",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block CUT_GOLD = registerBlock("cut_gold",
        new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs",
        new StairsBlock(ModBlocks.CUT_GOLD.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CUT_GOLD)));

    public static final Block CUT_GOLD_SLAB = registerBlock("cut_gold_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_GOLD)));

    // endregion

    // region Netherite Blocks

    public static final Block CUT_NETHERITE = registerBlock("cut_netherite",
        new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));

    public static final Block CUT_NETHERITE_STAIRS = registerBlock("cut_netherite_stairs",
        new StairsBlock(ModBlocks.CUT_NETHERITE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CUT_NETHERITE)));

    public static final Block CUT_NETHERITE_SLAB = registerBlock("cut_netherite_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_NETHERITE)));

    // endregion

    // region Lamps and Misc Blocks

    public static final Block LAVA_LAMP = registerBlock("lava_lamp",
        new LavaLampBlock(FabricBlockSettings.create().mapColor(MapColor.BLACK).luminance(15)
        .requiresTool().hardness(3.5F).strength(3.5F).sounds(ModSoundEvents.LAVA_LAMP).instrument(NoteBlockInstrument.HAT)));

    public static final Block HONEYLAMP = registerBlock("honeylamp",
        new Block(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK).luminance(15)));

    public static final Block CONGEALED_PISS = registerBlock("congealed_piss",
        new CongealedPissBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK).mapColor(MapColor.YELLOW)));

    public static final Block LANTERN_BLOCK = registerBlock("lantern_block",
        new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK)
        .sounds(BlockSoundGroup.LANTERN).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        .luminance(15).requiresTool().hardness(3.5F).strength(3.5F)));

    public static final Block SOUL_LANTERN_BLOCK = registerBlock("soul_lantern_block",
        new Block(FabricBlockSettings.copyOf(ModBlocks.LANTERN_BLOCK).luminance(10)));

    public static final Block SUNRISE_PAPER_LANTERN = registerBlock("sunrise_paper_lantern",
        new PaperLanternBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE)
        .sounds(ModSoundEvents.PAPER_LANTERN).luminance(15).strength(0.2F).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block TWILIGHT_PAPER_LANTERN = registerBlock("twilight_paper_lantern",
        new PaperLanternBlock(FabricBlockSettings.copyOf(ModBlocks.SUNRISE_PAPER_LANTERN).mapColor(MapColor.BLUE)));

    public static final Block BLOOMING_PAPER_LANTERN = registerBlock("blooming_paper_lantern",
        new PaperLanternBlock(FabricBlockSettings.copyOf(ModBlocks.SUNRISE_PAPER_LANTERN).mapColor(MapColor.PINK)));

    public static final Block JACK_O_SOULS = registerBlock("jack_o_souls",
        new CarvedPumpkinBlock(FabricBlockSettings.copyOf(Blocks.JACK_O_LANTERN).mapColor(MapColor.BROWN).luminance(10)));

    // endregion

    // region Tuff Blocks

    public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sounds(BlockSoundGroup.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_STAIRS = registerBlock("tuff_brick_stairs",
        new StairsBlock(ModBlocks.TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_SLAB = registerBlock("tuff_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_WALL = registerBlock("tuff_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.TUFF_BRICKS)));

    // endregion

    // region Obsidian Blocks

    public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
        new StairsBlock(ModBlocks.OBSIDIAN_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
        new PillarBlock(FabricBlockSettings.copyOf(ModBlocks.OBSIDIAN_BRICKS)));

    // endregion

    // region Glass Blocks

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
        new TransparentBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).nonOpaque().mapColor(MapColor.BLACK)
        .requiresTool().sounds(BlockSoundGroup.GLASS).instrument(NoteBlockInstrument.HAT)));

    public static final Block REINFORCED_GLASS_PANE = registerBlock("reinforced_glass_pane",
        new PaneBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).nonOpaque().mapColor(MapColor.BLACK)
        .requiresTool().sounds(BlockSoundGroup.GLASS).instrument(NoteBlockInstrument.HAT)));

    public static final Block SOUL_GLASS = registerBlock("soul_glass",
        new TransparentBlock(FabricBlockSettings.copyOf(Blocks.GLASS).mapColor(MapColor.BROWN)));

    public static final Block SOUL_GLASS_PANE = registerBlock("soul_glass_pane",
        new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).mapColor(MapColor.BROWN)));

    public static final Block GLOW_GLASS = registerBlock("glow_glass",
        new TransparentBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(5).emissiveLighting((state, world, pos) -> true)));

    public static final Block GLOW_GLASS_PANE = registerBlock("glow_glass_pane",
        new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).luminance(5).emissiveLighting((state, world, pos) -> true)));

    // endregion

    // region Bamboo Blocks

    public static final Block BAMBOO_WEAVE = registerBlock("bamboo_weave",
        new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)));

    public static final Block BAMBOO_WEAVE_STAIRS = registerBlock("bamboo_weave_stairs",
        new StairsBlock(ModBlocks.BAMBOO_WEAVE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.BAMBOO_WEAVE)));

    public static final Block BAMBOO_WEAVE_SLAB = registerBlock("bamboo_weave_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BAMBOO_WEAVE)));

    // endregion

    // region Nether Brick Blocks

    public static final Block BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).mapColor(MapColor.CYAN)));

    public static final Block BLUE_NETHER_BRICK_STAIRS = registerBlock("blue_nether_brick_stairs",
        new StairsBlock(ModBlocks.BLUE_NETHER_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_SLAB = registerBlock("blue_nether_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_WALL = registerBlock("blue_nether_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerBlock("chiseled_blue_nether_bricks",
        new Block(FabricBlockSettings.copyOf(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

    // endregion

    // region Wall Decoration Blocks

    public static final Block WALL_MOSS = registerBlock("wall_moss",
        new MossOverlayBlock(FabricBlockSettings.create().mapColor(MapColor.CLEAR).sounds(BlockSoundGroup.MOSS_CARPET)
        .noCollision().nonOpaque().strength(0.1F).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block WALL_WEB = registerBlock("wall_web",
        new WallWebBlock(FabricBlockSettings.create().mapColor(MapColor.CLEAR).sounds(BlockSoundGroup.HANGING_ROOTS)
        .noCollision().nonOpaque().strength(0.1F).pistonBehavior(PistonBehavior.DESTROY)));

    // endregion

    // region Packed Ice Blocks

    public static final Block PACKED_ICE_BRICKS = registerBlock("packed_ice_bricks",
        new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).requiresTool()));

    public static final Block PACKED_ICE_BRICK_STAIRS = registerBlock("packed_ice_brick_stairs",
        new StairsBlock(ModBlocks.PACKED_ICE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.PACKED_ICE_BRICKS)));

    public static final Block PACKED_ICE_BRICK_SLAB = registerBlock("packed_ice_brick_slab",
        new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.PACKED_ICE_BRICKS)));

    public static final Block PACKED_ICE_BRICK_WALL = registerBlock("packed_ice_brick_wall",
        new WallBlock(FabricBlockSettings.copyOf(ModBlocks.PACKED_ICE_BRICKS)));

    // endregion

    // region Infested Blocks

    public static final Block INFESTED_COBBLESTONE_BRICKS = registerBlock("infested_cobblestone_bricks",
        new InfestedBlock(COBBLESTONE_BRICKS, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));

    public static final Block INFESTED_STONE_PILLAR = registerBlock("infested_stone_pillar",
        new RotatedInfestedBlock(STONE_PILLAR, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));

    public static final Block INFESTED_STONE_TILES = registerBlock("infested_stone_tiles",
        new InfestedBlock(STONE_TILES, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));

    public static final Block INFESTED_DEEPSLATE_PILLAR = registerBlock("infested_deepslate_pillar",
        new RotatedInfestedBlock(DEEPSLATE_PILLAR, AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    // endregion

    // region Luigite

    public static final Block LUIGITE = registerBlock("luigite",
        new LuigiteBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK).mapColor(MapColor.GREEN)
        .sounds(ModSoundEvents.LUIGITE).instrument(ModNoteBlockInstruments.WAHOO)));

    public static final Block LUIGITE_HD = registerBlock("luigite_hd",
        new LuigiteBlock(FabricBlockSettings.copyOf(ModBlocks.LUIGITE)));

    public static final Block LUIGITE_4K = registerBlock("luigite_4k",
        new LuigiteBlock(FabricBlockSettings.copyOf(ModBlocks.LUIGITE)));

    // endregion

    // Registry

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, LottaBlocks.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, LottaBlocks.id(name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {}
}