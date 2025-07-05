package net.ambersand.lottablocks.registry.blocks;

import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.AmethystBrickSlabBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.AmethystBrickStairsBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.AmethystBrickWallBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.AmethystFloodlightBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.AmethystPillarBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.CongealedPissBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.LavaLampBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.MossOverlayBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.PaperLanternBlock;
import net.ambersand.lottablocks.registry.blocks.custom_blocks.WallWebBlock;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.InfestedRotatedPillarBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

// Updated for 1.21.1, updated from FabricBlockSettings to BlockBehaviour.Properties
@SuppressWarnings("unused")
public class ModBlocks {

    // Block Set Types

    public static final BlockSetType CAST_IRON_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.IRON)
        .soundGroup(SoundType.NETHERITE_BLOCK).register(LottaBlocks.id("cast_iron"));

    // Blocks

    // region Amethyst Blocks
    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
        new AmethystBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).sound(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_STAIRS = registerBlock("amethyst_brick_stairs",
        new AmethystBrickStairsBlock(ModBlocks.AMETHYST_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
        new AmethystBrickSlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_WALL = registerBlock("amethyst_brick_wall",
        new AmethystBrickWallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_PILLAR = registerBlock("amethyst_pillar",
        new AmethystPillarBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.AMETHYST_BRICKS)));

    public static final Block CHISELED_AMETHYST = registerBlock("chiseled_amethyst",
        new AmethystBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.AMETHYST_BRICKS)));

    public static final Block AMETHYST_FLOODLIGHT = registerBlock("amethyst_floodlight",
        new AmethystFloodlightBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
        .noOcclusion().sound(SoundType.LANTERN).lightLevel(state -> 15).strength(3.5F).pushReaction(PushReaction.DESTROY)));

    // endregion

    // region Dripstone Blocks

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_STAIRS = registerBlock("dripstone_brick_stairs",
        new StairBlock(ModBlocks.DRIPSTONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_BRICK_SLAB = registerBlock("dripstone_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_BRICK_WALL = registerBlock("dripstone_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_SHINGLES = registerBlock("dripstone_shingles",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_BRICKS)));

    public static final Block DRIPSTONE_SHINGLE_STAIRS = registerBlock("dripstone_shingle_stairs",
        new StairBlock(ModBlocks.DRIPSTONE_SHINGLES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_SHINGLES)));

    public static final Block DRIPSTONE_SHINGLE_SLAB = registerBlock("dripstone_shingle_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_SHINGLES)));

    public static final Block DRIPSTONE_SHINGLE_WALL = registerBlock("dripstone_shingle_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DRIPSTONE_SHINGLES)));

    // endregion

    // region Dirt Blocks

    public static final Block DIRT_BRICKS = registerBlock("dirt_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final Block DIRT_BRICK_STAIRS = registerBlock("dirt_brick_stairs",
        new StairBlock(ModBlocks.DIRT_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.DIRT_BRICKS)));

    public static final Block DIRT_BRICK_SLAB = registerBlock("dirt_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DIRT_BRICKS)));

    public static final Block DIRT_BRICK_WALL = registerBlock("dirt_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DIRT_BRICKS)));

    // endregion

    // region Cobblestone Blocks

    public static final Block COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    public static final Block COBBLESTONE_BRICK_STAIRS = registerBlock("cobblestone_brick_stairs",
        new StairBlock(ModBlocks.COBBLESTONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.COBBLESTONE_BRICKS)));

    public static final Block COBBLESTONE_BRICK_SLAB = registerBlock("cobblestone_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.COBBLESTONE_BRICKS)));

    public static final Block COBBLESTONE_BRICK_WALL = registerBlock("cobblestone_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.COBBLESTONE_BRICKS)));

    // endregion

    // region Blackstone Blocks

    public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));

    public static final Block POLISHED_BLACKSTONE_TILES = registerBlock("polished_blackstone_tiles",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));

    public static final Block POLISHED_BLACKSTONE_TILE_STAIRS = registerBlock("polished_blackstone_tile_stairs",
        new StairBlock(ModBlocks.POLISHED_BLACKSTONE_TILES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    public static final Block POLISHED_BLACKSTONE_TILE_SLAB = registerBlock("polished_blackstone_tile_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    public static final Block POLISHED_BLACKSTONE_TILE_WALL = registerBlock("polished_blackstone_tile_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BLACKSTONE_TILES)));

    // endregion

    // region Stone Blocks

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    public static final Block STONE_TILES = registerBlock("stone_tiles",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    public static final Block STONE_TILE_STAIRS = registerBlock("stone_tile_stairs",
        new StairBlock(ModBlocks.STONE_TILES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.STONE_TILES)));

    public static final Block STONE_TILE_SLAB = registerBlock("stone_tile_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.STONE_TILES)));

    public static final Block STONE_TILE_WALL = registerBlock("stone_tile_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.STONE_TILES)));

    // endregion

    // region Deepslate Blocks

    public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));

    // endregion

    // region Calcite Blocks

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));

    public static final Block CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
        new StairBlock(ModBlocks.CALCITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.CALCITE_BRICKS)));

    public static final Block CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CALCITE_BRICKS)));

    public static final Block CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CALCITE_BRICKS)));

    // endregion

    // region Andesite Blocks

    public static final Block POLISHED_ANDESITE_BRICKS = registerBlock("polished_andesite_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)));

    public static final Block POLISHED_ANDESITE_BRICK_STAIRS = registerBlock("polished_andesite_brick_stairs",
        new StairBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    public static final Block POLISHED_ANDESITE_BRICK_SLAB = registerBlock("polished_andesite_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    public static final Block POLISHED_ANDESITE_BRICK_WALL = registerBlock("polished_andesite_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_ANDESITE_BRICKS)));

    // endregion

    // region Diorite Blocks

    public static final Block POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)));

    public static final Block POLISHED_DIORITE_BRICK_STAIRS = registerBlock("polished_diorite_brick_stairs",
        new StairBlock(ModBlocks.POLISHED_DIORITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_DIORITE_BRICKS)));

    public static final Block POLISHED_DIORITE_BRICK_SLAB = registerBlock("polished_diorite_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_DIORITE_BRICKS)));

    public static final Block POLISHED_DIORITE_BRICK_WALL = registerBlock("polished_diorite_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_DIORITE_BRICKS)));

    // endregion

    // region Granite Blocks

    public static final Block POLISHED_GRANITE_BRICKS = registerBlock("polished_granite_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)));

    public static final Block POLISHED_GRANITE_BRICK_STAIRS = registerBlock("polished_granite_brick_stairs",
        new StairBlock(ModBlocks.POLISHED_GRANITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_GRANITE_BRICKS)));

    public static final Block POLISHED_GRANITE_BRICK_SLAB = registerBlock("polished_granite_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_GRANITE_BRICKS)));

    public static final Block POLISHED_GRANITE_BRICK_WALL = registerBlock("polished_granite_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_GRANITE_BRICKS)));

    // endregion

    // region Basalt Blocks

    public static final Block POLISHED_BASALT_BRICKS = registerBlock("polished_basalt_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT)));

    public static final Block POLISHED_BASALT_BRICK_STAIRS = registerBlock("polished_basalt_brick_stairs",
        new StairBlock(ModBlocks.POLISHED_BASALT_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_BRICK_SLAB = registerBlock("polished_basalt_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_BRICK_WALL = registerBlock("polished_basalt_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_TILES = registerBlock("polished_basalt_tiles",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_BRICKS)));

    public static final Block POLISHED_BASALT_TILE_STAIRS = registerBlock("polished_basalt_tile_stairs",
        new StairBlock(ModBlocks.POLISHED_BASALT_TILES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block POLISHED_BASALT_TILE_SLAB = registerBlock("polished_basalt_tile_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block POLISHED_BASALT_TILE_WALL = registerBlock("polished_basalt_tile_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_TILES)));

    public static final Block CHISELED_POLISHED_BASALT = registerBlock("chiseled_polished_basalt",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHED_BASALT_BRICKS)));

    // endregion

    // region Cast Iron Blocks

    public static final Block CAST_IRON_BLOCK = registerBlock("cast_iron_block",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .mapColor(MapColor.COLOR_BLACK).sound(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_CAST_IRON = registerBlock("cut_cast_iron",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CAST_IRON_BLOCK)));

    public static final Block CUT_CAST_IRON_STAIRS = registerBlock("cut_cast_iron_stairs",
        new StairBlock(ModBlocks.CUT_CAST_IRON.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_CAST_IRON)));

    public static final Block CUT_CAST_IRON_SLAB = registerBlock("cut_cast_iron_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_CAST_IRON)));

    public static final Block CAST_IRON_DOOR = registerBlock("cast_iron_door",
        new DoorBlock(CAST_IRON_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).mapColor(MapColor.COLOR_BLACK)));

    public static final Block CAST_IRON_TRAPDOOR = registerBlock("cast_iron_trapdoor",
        new TrapDoorBlock(CAST_IRON_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR).mapColor(MapColor.COLOR_BLACK)));

    // endregion

    // region Gold Blocks

    public static final Block CHISELED_GOLD_BLOCK = registerBlock("chiseled_gold_block",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final Block GOLD_PILLAR = registerBlock("gold_pillar",
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final Block CUT_GOLD = registerBlock("cut_gold",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final Block CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs",
        new StairBlock(ModBlocks.CUT_GOLD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_GOLD)));

    public static final Block CUT_GOLD_SLAB = registerBlock("cut_gold_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_GOLD)));

    // endregion

    // region Netherite Blocks

    public static final Block CUT_NETHERITE = registerBlock("cut_netherite",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));

    public static final Block CUT_NETHERITE_STAIRS = registerBlock("cut_netherite_stairs",
        new StairBlock(ModBlocks.CUT_NETHERITE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_NETHERITE)));

    public static final Block CUT_NETHERITE_SLAB = registerBlock("cut_netherite_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CUT_NETHERITE)));

    // endregion

    // region Lamps and Misc Blocks

    public static final Block LAVA_LAMP = registerBlock("lava_lamp",
        new LavaLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).lightLevel(state -> 15)
        .requiresCorrectToolForDrops().destroyTime(3.5F).strength(3.5F).sound(ModSoundEvents.LAVA_LAMP).instrument(NoteBlockInstrument.HAT)));

    public static final Block HONEYLAMP = registerBlock("honeylamp",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.HONEYCOMB_BLOCK).lightLevel(state -> 15)));

    public static final Block CONGEALED_PISS = registerBlock("congealed_piss",
        new CongealedPissBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HONEY_BLOCK).mapColor(MapColor.COLOR_YELLOW)));

    public static final Block LANTERN_BLOCK = registerBlock("lantern_block",
        new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
        .sound(SoundType.LANTERN).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        .lightLevel(state -> 15).requiresCorrectToolForDrops().destroyTime(3.5F).strength(3.5F)));

    public static final Block SOUL_LANTERN_BLOCK = registerBlock("soul_lantern_block",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.LANTERN_BLOCK).lightLevel(state -> 15)));

    public static final Block SUNRISE_PAPER_LANTERN = registerBlock("sunrise_paper_lantern",
        new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
        .sound(ModSoundEvents.PAPER_LANTERN).lightLevel(state -> 15).strength(0.2F).pushReaction(PushReaction.DESTROY)));

    public static final Block TWILIGHT_PAPER_LANTERN = registerBlock("twilight_paper_lantern",
        new PaperLanternBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SUNRISE_PAPER_LANTERN).mapColor(MapColor.COLOR_BLUE)));

    public static final Block BLOOMING_PAPER_LANTERN = registerBlock("blooming_paper_lantern",
        new PaperLanternBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SUNRISE_PAPER_LANTERN).mapColor(MapColor.COLOR_PINK)));

    public static final Block JACK_O_SOULS = registerBlock("jack_o_souls",
        new CarvedPumpkinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN).mapColor(MapColor.COLOR_BROWN).lightLevel(state -> 15)));

    // endregion

    // region Tuff Blocks

    public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_STAIRS = registerBlock("tuff_brick_stairs",
        new StairBlock(ModBlocks.TUFF_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_SLAB = registerBlock("tuff_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_WALL = registerBlock("tuff_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.TUFF_BRICKS)));

    // endregion

    // region Obsidian Blocks

    public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    public static final Block OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
        new StairBlock(ModBlocks.OBSIDIAN_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.OBSIDIAN_BRICKS)));

    // endregion

    // region Glass Blocks

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
        new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion().mapColor(MapColor.COLOR_BLACK)
        .requiresCorrectToolForDrops().sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT)));

    public static final Block REINFORCED_GLASS_PANE = registerBlock("reinforced_glass_pane",
        new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion().mapColor(MapColor.COLOR_BLACK)
        .requiresCorrectToolForDrops().sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT)));

    public static final Block SOUL_GLASS = registerBlock("soul_glass",
        new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).mapColor(MapColor.COLOR_BROWN)));

    public static final Block SOUL_GLASS_PANE = registerBlock("soul_glass_pane",
        new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_BROWN)));

    public static final Block GLOW_GLASS = registerBlock("glow_glass",
        new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(state -> 5).emissiveRendering((state, world, pos) -> true)));

    public static final Block GLOW_GLASS_PANE = registerBlock("glow_glass_pane",
        new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).lightLevel(state -> 5).emissiveRendering((state, world, pos) -> true)));

    // endregion

    // region Bamboo Blocks

    public static final Block BAMBOO_WEAVE = registerBlock("bamboo_weave",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));

    public static final Block BAMBOO_WEAVE_STAIRS = registerBlock("bamboo_weave_stairs",
        new StairBlock(ModBlocks.BAMBOO_WEAVE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.BAMBOO_WEAVE)));

    public static final Block BAMBOO_WEAVE_SLAB = registerBlock("bamboo_weave_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BAMBOO_WEAVE)));

    // endregion

    // region Nether Brick Blocks

    public static final Block BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS).mapColor(MapColor.COLOR_CYAN)));

    public static final Block BLUE_NETHER_BRICK_STAIRS = registerBlock("blue_nether_brick_stairs",
        new StairBlock(ModBlocks.BLUE_NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_SLAB = registerBlock("blue_nether_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_WALL = registerBlock("blue_nether_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerBlock("chiseled_blue_nether_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BLUE_NETHER_BRICKS)));

    public static final Block CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));

    // endregion

    // region Wall Decoration Blocks

    public static final Block WALL_MOSS = registerBlock("wall_moss",
        new MossOverlayBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).sound(SoundType.MOSS_CARPET)
        .noCollission().noOcclusion().strength(0.1F).pushReaction(PushReaction.DESTROY)));

    public static final Block WALL_WEB = registerBlock("wall_web",
        new WallWebBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).sound(SoundType.HANGING_ROOTS)
        .noCollission().noOcclusion().strength(0.1F).pushReaction(PushReaction.DESTROY)));

    // endregion

    // region Packed Ice Blocks

    public static final Block PACKED_ICE_BRICKS = registerBlock("packed_ice_bricks",
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).requiresCorrectToolForDrops()));

    public static final Block PACKED_ICE_BRICK_STAIRS = registerBlock("packed_ice_brick_stairs",
        new StairBlock(ModBlocks.PACKED_ICE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.PACKED_ICE_BRICKS)));

    public static final Block PACKED_ICE_BRICK_SLAB = registerBlock("packed_ice_brick_slab",
        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.PACKED_ICE_BRICKS)));

    public static final Block PACKED_ICE_BRICK_WALL = registerBlock("packed_ice_brick_wall",
        new WallBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.PACKED_ICE_BRICKS)));

    // endregion

    // region Infested Blocks

    public static final Block INFESTED_COBBLESTONE_BRICKS = registerBlock("infested_cobblestone_bricks",
        new InfestedBlock(COBBLESTONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));

    public static final Block INFESTED_STONE_PILLAR = registerBlock("infested_stone_pillar",
        new InfestedRotatedPillarBlock(STONE_PILLAR, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));

    public static final Block INFESTED_STONE_TILES = registerBlock("infested_stone_tiles",
        new InfestedBlock(STONE_TILES, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));

    public static final Block INFESTED_DEEPSLATE_PILLAR = registerBlock("infested_deepslate_pillar",
        new InfestedRotatedPillarBlock(DEEPSLATE_PILLAR, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)));

    // endregion

    // Registry

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, LottaBlocks.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, LottaBlocks.id(name), new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        LottaBlocks.LOGGER.info("Registering custom blocks for " + LottaBlocks.MOD_ID);
    }
}