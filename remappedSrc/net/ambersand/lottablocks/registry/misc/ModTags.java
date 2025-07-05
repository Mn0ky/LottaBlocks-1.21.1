package net.ambersand.lottablocks.registry.misc;

import net.ambersand.lottablocks.LottaBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

@SuppressWarnings("all")
public class ModTags {

    // region Block Tags

    public static final TagKey<Block> OCCLUDING_GLASS = registerBlockTag("occluding_glass");
    public static final TagKey<Block> OCCLUDING_GLASS_PANES = registerBlockTag("occluding_glass_panes");

    // endregion


    // region Biome Tags

    public static final TagKey<Biome>
        HAS_ZOMBIE_DUNGEON = registerBiomeTag("has_structure/zombie_dungeon"),
        HAS_SKELETON_DUNGEON = registerBiomeTag("has_structure/skeleton_dungeon"),
        HAS_HUSK_DUNGEON = registerBiomeTag("has_structure/husk_dungeon"),
        HAS_STRAY_DUNGEON = registerBiomeTag("has_structure/stray_dungeon"),
        HAS_SPIDER_DUNGEON = registerBiomeTag("has_structure/spider_dungeon"),
        HAS_SILVERFISH_DUNGEON = registerBiomeTag("has_structure/silverfish_dungeon"),
        HAS_PISS_FOUNTAIN = registerBiomeTag("has_structure/piss_fountain")
    ;

    // endregion

    // region Registry

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, LottaBlocks.id(name));
    }

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, LottaBlocks.id(name));
    }

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.of(RegistryKeys.BIOME, LottaBlocks.id(name));
    }

    // endregion
}