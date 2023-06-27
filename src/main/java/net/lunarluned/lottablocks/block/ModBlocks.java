package net.lunarluned.lottablocks.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.lunarluned.lottablocks.LottaBlocks;
import net.lunarluned.lottablocks.block.custom_blocks.*;
import net.lunarluned.lottablocks.sound.ModSoundEvents;

@SuppressWarnings("ALL")
public class ModBlocks {

// List of Blocks:

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
    new AmethystBricksBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MapColor.COLOR_PURPLE).requiresTool().sound(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_STAIRS = registerBlock("amethyst_brick_stairs",
    new AmethystBrickStairsBlock(ModBlocks.AMETHYST_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)
    .mapColor(MapColor.COLOR_PURPLE).sound(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
    new AmethystBrickSlabBlock(FabricBlockSettings.copyOf(ModBlocks.AMETHYST_BRICKS)
    .mapColor(MapColor.COLOR_PURPLE).sound(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_BRICK_WALL = registerBlock("amethyst_brick_wall",
    new AmethystBrickWallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MapColor.COLOR_PURPLE).requiresTool().sounds(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_PILLAR = registerBlock("amethyst_pillar",
    new AmethystPillarBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MapColor.COLOR_PURPLE).requiresTool().sounds(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block CHISELED_AMETHYST = registerBlock("chiseled_amethyst",
    new AmethystBricksBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MapColor.COLOR_PURPLE).requiresTool().sounds(ModSoundEvents.AMETHYST_BRICKS)));

    public static final Block AMETHYST_FLOODLIGHT = registerBlock("amethyst_floodlight",
    new AmethystFloodlightBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_BLACK)
    .nonOpaque().sounds(SoundType.LANTERN).luminance(15).strength(3.5f)));

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_STAIRS = registerBlock("dripstone_brick_stairs",
    new ModStairsBlock(ModBlocks.DRIPSTONE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_SLAB = registerBlock("dripstone_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_WALL = registerBlock("dripstone_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_SHINGLES = registerBlock("dripstone_shingles",
    new Block(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_SHINGLE_STAIRS = registerBlock("dripstone_shingle_stairs",
    new ModStairsBlock(ModBlocks.DRIPSTONE_SHINGLES.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_SHINGLE_SLAB = registerBlock("dripstone_shingle_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_SHINGLE_WALL = registerBlock("dripstone_shingle_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.DRIPSTONE_BLOCK)));

    public static final Block DIRT_BRICKS = registerBlock("dirt_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.DIRT)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sound(SoundType.GRAVEL)));

    public static final Block DIRT_BRICK_STAIRS = registerBlock("dirt_brick_stairs",
    new StairBlock(ModBlocks.DIRT_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.DIRT)
    .mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRAVEL)));

    public static final Block DIRT_BRICK_SLAB = registerBlock("dirt_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.DIRT)
    .mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRAVEL)));

    public static final Block DIRT_BRICK_WALL = registerBlock("dirt_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.DIRT)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.GRAVEL)));

    public static final Block COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sound(SoundType.STONE)));

    public static final Block COBBLESTONE_BRICK_STAIRS = registerBlock("cobblestone_brick_stairs",
    new StairBlock(ModBlocks.COBBLESTONE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
    .mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE)));

    public static final Block COBBLESTONE_BRICK_SLAB = registerBlock("cobblestone_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
    .mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE)));

    public static final Block COBBLESTONE_BRICK_WALL = registerBlock("cobblestone_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
    new ModPillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BLACKSTONE_TILES = registerBlock("polished_blackstone_tiles",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BLACKSTONE_TILE_STAIRS = registerBlock("polished_blackstone_tile_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_BLACKSTONE_TILES.defaultBlockState(), FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BLACKSTONE_TILE_SLAB = registerBlock("polished_blackstone_tile_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BLACKSTONE_TILE_WALL = registerBlock("polished_blackstone_tile_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
    new ModPillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.DEEPSLATE_BRICKS)));

    public static final Block STONE_TILES = registerBlock("stone_tiles",
    new Block(FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block STONE_TILE_STAIRS = registerBlock("stone_tile_stairs",
    new ModStairsBlock(ModBlocks.STONE_TILES.defaultBlockState(), FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block STONE_TILE_SLAB = registerBlock("stone_tile_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block STONE_TILE_WALL = registerBlock("stone_tile_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
    new ModPillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.DEEPSLATE_BRICKS)));

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.CALCITE)));

    public static final Block CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
    new ModStairsBlock(ModBlocks.CALCITE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.CALCITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.CALCITE)));

    public static final Block CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.CALCITE)));

    public static final Block CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.CALCITE)));

    public static final Block POLISHED_ANDESITE_BRICKS = registerBlock("polished_andesite_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_ANDESITE_BRICK_STAIRS = registerBlock("polished_andesite_brick_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_ANDESITE_BRICK_SLAB = registerBlock("polished_andesite_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_ANDESITE_BRICK_WALL = registerBlock("polished_andesite_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_DIORITE_BRICK_STAIRS = registerBlock("polished_diorite_brick_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_DIORITE_BRICK_SLAB = registerBlock("polished_diorite_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_DIORITE_BRICK_WALL = registerBlock("polished_diorite_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)
    .mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_GRANITE_BRICKS = registerBlock("polished_granite_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_GRANITE_BRICK_STAIRS = registerBlock("polished_granite_brick_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_GRANITE_BRICK_SLAB = registerBlock("polished_granite_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_GRANITE_BRICK_WALL = registerBlock("polished_granite_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.STONE)));

    public static final Block POLISHED_BASALT_BRICKS = registerBlock("polished_basalt_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_BRICK_STAIRS = registerBlock("polished_basalt_brick_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_BASALT_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_BRICK_SLAB = registerBlock("polished_basalt_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_BRICK_WALL = registerBlock("polished_basalt_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_TILES = registerBlock("polished_basalt_tiles",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_TILE_STAIRS = registerBlock("polished_basalt_tile_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_BASALT_TILES.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_TILE_SLAB = registerBlock("polished_basalt_tile_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block POLISHED_BASALT_TILE_WALL = registerBlock("polished_basalt_tile_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.BASALT)));

    public static final Block CHISELED_POLISHED_BASALT = registerBlock("chiseled_polished_basalt",
    new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)
    .mapColor(MapColor.COLOR_GRAY).requiresTool().sounds(SoundType.BASALT)));

    public static final Block CAST_IRON_BLOCK = registerBlock("cast_iron_block",
    new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_CAST_IRON = registerBlock("cut_cast_iron",
    new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_CAST_IRON_STAIRS = registerBlock("cut_cast_iron_stairs",
    new ModStairsBlock(ModBlocks.CUT_CAST_IRON.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_CAST_IRON_SLAB = registerBlock("cut_cast_iron_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

// Door and Trapdoor code broke on 1.20. womp womp

    //public static final Block CAST_IRON_DOOR = registerBlock("cast_iron_door",
    //new DoorBlock(FabricBlockSettings.of()
    //.mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    //public static final Block CAST_IRON_TRAPDOOR = registerBlock("cast_iron_trapdoor",
    //new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR)
   // .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CHISELED_GOLD_BLOCK = registerBlock("chiseled_gold_block",
    new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
    .mapColor(MapColor.GOLD).requiresTool().sounds(SoundType.METAL)));

    public static final Block GOLD_PILLAR = registerBlock("gold_pillar",
    new ModPillarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
    .mapColor(MapColor.GOLD).requiresTool().sounds(SoundType.METAL)));

    public static final Block CUT_GOLD = registerBlock("cut_gold",
    new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
    .mapColor(MapColor.GOLD).requiresTool().sounds(SoundType.METAL)));

    public static final Block CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs",
    new ModStairsBlock(ModBlocks.CUT_GOLD.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
    .mapColor(MapColor.GOLD).requiresTool().sounds(SoundType.METAL)));

    public static final Block CUT_GOLD_SLAB = registerBlock("cut_gold_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
    .mapColor(MapColor.GOLD).requiresTool().sounds(SoundType.METAL)));

    public static final Block CUT_NETHERITE = registerBlock("cut_netherite",
    new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_NETHERITE_STAIRS = registerBlock("cut_netherite_stairs",
    new ModStairsBlock(ModBlocks.CUT_GOLD.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_NETHERITE_SLAB = registerBlock("cut_netherite_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
    .mapColor(MapColor.COLOR_BROWN).requiresTool().sounds(SoundType.NETHERITE_BLOCK)));

    public static final Block LAVA_LAMP = registerBlock("lava_lamp",
    new LavaLampBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_RED)
    .sounds(ModSoundEvents.LAVA_LAMP).luminance(15).requiresTool().hardness(3.5f).strength(3.5f)));

    public static final Block HONEYLAMP = registerBlock("honeylamp",
    new Block(FabricBlockSettings.of().mapColor(MapColor.COLOR_ORANGE)
    .sounds(SoundType.CORAL_BLOCK).luminance(15).strength(0.6F)));

    public static final Block CONGEALED_PISS = registerBlock("congealed_piss",
    new CongealedPissBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_ORANGE)
    .sounds(SoundType.MUD).resistance(5).hardness(1).noCollision().noLootTable()));

    public static final Block LANTERN_BLOCK = registerBlock("lantern_block",
    new Block(FabricBlockSettings.of().mapColor(MapColor.COLOR_BLACK)
    .sounds(SoundType.LANTERN).luminance(15).requiresTool().hardness(3.5f).strength(3.5f)));

    public static final Block SOUL_LANTERN_BLOCK = registerBlock("soul_lantern_block",
    new Block(FabricBlockSettings.of().mapColor(MapColor.COLOR_BLACK)
    .sounds(SoundType.LANTERN).luminance(10).requiresTool().hardness(3.5f).strength(3.5f)));

    public static final Block SUNRISE_PAPER_LANTERN = registerBlock("sunrise_paper_lantern",
    new PaperLanternBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_YELLOW)
    .sounds(ModSoundEvents.PAPER_LANTERN).luminance(15).strength(0.2f)));

    public static final Block TWILIGHT_PAPER_LANTERN = registerBlock("twilight_paper_lantern",
    new PaperLanternBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_BLUE)
    .sounds(ModSoundEvents.PAPER_LANTERN).luminance(15).strength(0.2f)));

    public static final Block BLOOMING_PAPER_LANTERN = registerBlock("blooming_paper_lantern",
    new PaperLanternBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_PINK)
    .sounds(ModSoundEvents.PAPER_LANTERN).luminance(15).strength(0.2f)));

    public static final Block JACK_O_SOULS = registerBlock("jack_o_souls",
    new CarvedPumpkinBlock(FabricBlockSettings.copyOf(Blocks.PUMPKIN)
    .mapColor(MapColor.COLOR_BROWN).luminance(15).sounds(SoundType.WOOD)));

    public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.TUFF)
    .mapColor(MapColor.TERRACOTTA_GRAY).requiresTool().sounds(ModSoundEvents.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_STAIRS = registerBlock("tuff_brick_stairs",
    new ModStairsBlock(ModBlocks.TUFF_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.TUFF)
    .mapColor(MapColor.TERRACOTTA_GRAY).requiresTool().sounds(ModSoundEvents.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_SLAB = registerBlock("tuff_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)
    .mapColor(MapColor.TERRACOTTA_GRAY).requiresTool().sounds(ModSoundEvents.TUFF_BRICKS)));

    public static final Block TUFF_BRICK_WALL = registerBlock("tuff_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)
    .mapColor(MapColor.TERRACOTTA_GRAY).requiresTool().sounds(ModSoundEvents.TUFF_BRICKS)));

    public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
    new ModStairsBlock(ModBlocks.OBSIDIAN_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
    new ModPillarBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.STONE)));

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
    new ModGlassBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
    .nonOpaque().mapColor(MapColor.COLOR_BLACK).requiresTool().sounds(SoundType.GLASS)));

    public static final Block SOUL_GLASS = registerBlock("soul_glass",
    new SoulGlassBlock(FabricBlockSettings.of().mapColor(MapColor.COLOR_BROWN)
    .nonOpaque().sounds(SoundType.GLASS).hardness(0.3f).strength(0.3f)));

    public static final Block GLOW_GLASS = registerBlock("glow_glass",
    new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)
    .nonOpaque().mapColor(MapColor.NONE).sounds(SoundType.GLASS)
    .luminance(5).emissiveLighting((state, world, pos) -> true)));

    public static final Block BAMBOO_WEAVE = registerBlock("bamboo_weave",
    new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_MOSAIC).sounds(SoundType.BAMBOO_WOOD)));

    public static final Block BAMBOO_WEAVE_STAIRS = registerBlock("bamboo_weave_stairs",
    new ModStairsBlock(ModBlocks.BAMBOO_WEAVE.defaultBlockState(),
    FabricBlockSettings.copyOf(ModBlocks.BAMBOO_WEAVE).sounds(SoundType.BAMBOO_WOOD)));

    public static final Block BAMBOO_WEAVE_SLAB = registerBlock("bamboo_weave_slab",
    new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BAMBOO_WEAVE).sounds(SoundType.BAMBOO_WOOD)));

    public static final Block BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)
    .mapColor(MapColor.COLOR_CYAN).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_STAIRS = registerBlock("blue_nether_brick_stairs",
    new ModStairsBlock(ModBlocks.BLUE_NETHER_BRICKS.defaultBlockState(),
    FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICK_STAIRS)
    .mapColor(MapColor.COLOR_CYAN).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_SLAB = registerBlock("blue_nether_brick_slab",
    new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICK_SLAB)
    .mapColor(MapColor.COLOR_CYAN).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICK_WALL = registerBlock("blue_nether_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICK_WALL)
    .mapColor(MapColor.COLOR_CYAN).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerBlock("chiseled_blue_nether_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_NETHER_BRICKS)
    .mapColor(MapColor.COLOR_CYAN).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
    new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_NETHER_BRICKS)
    .mapColor(MapColor.COLOR_RED).requiresTool().sounds(SoundType.NETHER_BRICKS)));

    public static final Block WALL_MOSS = registerBlock("wall_moss",
    new MossOverlayBlock(FabricBlockSettings.of()
    .sounds(SoundType.MOSS_CARPET).noCollision().nonOpaque().strength(0.1f)));

    public static final Block WALL_WEB = registerBlock("wall_web",
    new WallWebBlock(FabricBlockSettings.of()
    .sounds(SoundType.HANGING_ROOTS).noCollision().nonOpaque().strength(0.1f)));

// Registry for Blocks:

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(LottaBlocks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(LottaBlocks.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        System.out.println("Registering Blocks for " + LottaBlocks.MOD_ID);
    }

}