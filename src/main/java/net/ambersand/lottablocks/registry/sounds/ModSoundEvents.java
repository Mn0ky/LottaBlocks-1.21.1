package net.ambersand.lottablocks.registry.sounds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.ambersand.lottablocks.LottaBlocks;

public class ModSoundEvents {

    // region Block Sounds

    public static final SoundEvent BLOCK_AMETHYST_BRICKS_BREAK = registerSoundEvent("block.amethyst_bricks.break");
    public static final SoundEvent BLOCK_AMETHYST_BRICKS_STEP = registerSoundEvent("block.amethyst_bricks.step");
    public static final SoundEvent BLOCK_AMETHYST_BRICKS_PLACE = registerSoundEvent("block.amethyst_bricks.place");
    public static final SoundEvent BLOCK_AMETHYST_BRICKS_HIT = registerSoundEvent("block.amethyst_bricks.hit");
    public static final SoundEvent BLOCK_AMETHYST_BRICKS_FALL = registerSoundEvent("block.amethyst_bricks.fall");

    public static final SoundEvent BLOCK_LAVA_LAMP_BREAK = registerSoundEvent("block.lava_lamp.break");
    public static final SoundEvent BLOCK_LAVA_LAMP_STEP = registerSoundEvent("block.lava_lamp.step");
    public static final SoundEvent BLOCK_LAVA_LAMP_PLACE = registerSoundEvent("block.lava_lamp.place");
    public static final SoundEvent BLOCK_LAVA_LAMP_HIT = registerSoundEvent("block.lava_lamp.hit");
    public static final SoundEvent BLOCK_LAVA_LAMP_FALL = registerSoundEvent("block.lava_lamp.fall");

    public static final SoundEvent BLOCK_PAPER_LANTERN_BREAK = registerSoundEvent("block.paper_lantern.break");
    public static final SoundEvent BLOCK_PAPER_LANTERN_STEP = registerSoundEvent("block.paper_lantern.step");
    public static final SoundEvent BLOCK_PAPER_LANTERN_PLACE = registerSoundEvent("block.paper_lantern.place");
    public static final SoundEvent BLOCK_PAPER_LANTERN_HIT = registerSoundEvent("block.paper_lantern.hit");
    public static final SoundEvent BLOCK_PAPER_LANTERN_FALL = registerSoundEvent("block.paper_lantern.fall");

    public static final SoundEvent BLOCK_LUIGITE_BREAK = registerSoundEvent("block.luigite.break");
    public static final SoundEvent BLOCK_LUIGITE_STEP = registerSoundEvent("block.luigite.step");
    public static final SoundEvent BLOCK_LUIGITE_PLACE = registerSoundEvent("block.luigite.place");
    public static final SoundEvent BLOCK_LUIGITE_HIT = registerSoundEvent("block.luigite.hit");
    public static final SoundEvent BLOCK_LUIGITE_FALL = registerSoundEvent("block.luigite.fall");
    public static final SoundEvent BLOCK_LUIGITE_SCREAM = registerSoundEvent("block.luigite.scream");

    // endregion

    // region Block Sound Groups

    public static final SoundType AMETHYST_BRICKS = new SoundType(1F, 1F,
        ModSoundEvents.BLOCK_AMETHYST_BRICKS_BREAK, ModSoundEvents.BLOCK_AMETHYST_BRICKS_STEP, ModSoundEvents.BLOCK_AMETHYST_BRICKS_PLACE,
        ModSoundEvents.BLOCK_AMETHYST_BRICKS_HIT, ModSoundEvents.BLOCK_AMETHYST_BRICKS_FALL);

    public static final SoundType LAVA_LAMP = new SoundType(1F, 1F,
        ModSoundEvents.BLOCK_LAVA_LAMP_BREAK, ModSoundEvents.BLOCK_LAVA_LAMP_STEP, ModSoundEvents.BLOCK_LAVA_LAMP_PLACE,
        ModSoundEvents.BLOCK_LAVA_LAMP_HIT, ModSoundEvents.BLOCK_LAVA_LAMP_FALL);

    public static final SoundType PAPER_LANTERN = new SoundType(1F, 1F,
        ModSoundEvents.BLOCK_PAPER_LANTERN_BREAK, ModSoundEvents.BLOCK_PAPER_LANTERN_STEP, ModSoundEvents.BLOCK_PAPER_LANTERN_PLACE,
        ModSoundEvents.BLOCK_PAPER_LANTERN_HIT, ModSoundEvents.BLOCK_PAPER_LANTERN_FALL);

    public static final SoundType LUIGITE = new SoundType(1F, 1F,
        ModSoundEvents.BLOCK_LUIGITE_BREAK, ModSoundEvents.BLOCK_LUIGITE_STEP, ModSoundEvents.BLOCK_LUIGITE_PLACE,
        ModSoundEvents.BLOCK_LUIGITE_HIT, ModSoundEvents.BLOCK_LUIGITE_FALL);

    // endregion

    private static SoundEvent registerSoundEvent(String name) {
        ResourceLocation resourceLocation = LottaBlocks.id(name);
        SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(resourceLocation);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, resourceLocation, soundEvent);
    }

    public static void registerSounds() {}
}