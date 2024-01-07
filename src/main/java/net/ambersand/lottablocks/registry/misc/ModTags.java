package net.ambersand.lottablocks.registry.misc;

import net.ambersand.lottablocks.LottaBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("all")
public class ModTags {

    // region Block Tags

    public static final TagKey<Block> OCCLUDING_GLASS = registerBlockTag("occluding_glass");
    public static final TagKey<Block> OCCLUDING_GLASS_PANES = registerBlockTag("occluding_glass_panes");

    // endregion

    // region Item Tags

    public static final TagKey<Item> LUIGITE_BLOCKS = registerItemTag("luigite_blocks");

    // endregion

    // region Registry

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, LottaBlocks.id(name));
    }

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, LottaBlocks.id(name));
    }

    // endregion
}