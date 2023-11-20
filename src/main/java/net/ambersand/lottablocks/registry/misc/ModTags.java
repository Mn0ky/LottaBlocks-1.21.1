package net.ambersand.lottablocks.registry.misc;

import net.ambersand.lottablocks.LottaBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    // region Item Tags

    public static final TagKey<Item> LUIGITE_BLOCKS = registerItemTag("luigite_blocks");

    // endregion

    // region Registry

    @SuppressWarnings("all")
    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, LottaBlocks.id(name));
    }

    // endregion
}