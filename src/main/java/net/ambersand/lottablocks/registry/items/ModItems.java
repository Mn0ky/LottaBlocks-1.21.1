package net.ambersand.lottablocks.registry.items;

import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.items.custom_items.LuigiteJumpscareItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ModItems {

    public static final Item LUIGITE_JUMPSCARE = registerItem("luigite_jumpscare", new LuigiteJumpscareItem(new FabricItemSettings().stacksTo(1).rarity(Rarity.RARE)));

    // Registry

    @SuppressWarnings("all")
    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, LottaBlocks.id(name), item);
    }

    public static void registerModItems() {}
}