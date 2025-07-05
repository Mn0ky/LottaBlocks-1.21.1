package net.ambersand.lottablocks.mixin.blocks;

import net.ambersand.lottablocks.registry.misc.ModNoteBlockInstruments;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Arrays;
import java.util.Locale;

@Mixin(NoteBlockInstrument.class)
public class NoteBlockInstrumentMixin {

    @Mutable @Shadow @Final private static NoteBlockInstrument[] $VALUES;

    @SuppressWarnings("unused")
    public <T> NoteBlockInstrumentMixin(String enumName, int ordinal, String lowerCase, RegistryEntry<T> direct, NoteBlockInstrument.Type type) {
        throw new UnsupportedOperationException("Replaced by Mixin");
    }

    @SuppressWarnings("all")
    @Unique
    private static NoteBlockInstrument createNoteBlockInstrument(String enumName, int ordinal, SoundEvent soundEvent) {
        return (NoteBlockInstrument)(Object) new NoteBlockInstrumentMixin(enumName, ordinal, enumName.toLowerCase(Locale.ROOT), RegistryEntry.of(soundEvent), NoteBlockInstrument.Type.BASE_BLOCK);
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;$VALUES:[Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;", shift = At.Shift.AFTER))
    private static void lottaBlocks$addNoteBlockInstruments(CallbackInfo info) {
        int ordinal = $VALUES.length;
        $VALUES = Arrays.copyOf($VALUES, ordinal + 1);

        ModNoteBlockInstruments.WAHOO = $VALUES[ordinal] = createNoteBlockInstrument("wahoo", ordinal, ModSoundEvents.NOTE_BLOCK_WAHOO);
    }
}