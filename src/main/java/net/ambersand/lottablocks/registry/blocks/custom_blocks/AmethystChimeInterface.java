package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public interface AmethystChimeInterface {

    default void playChimeSounds(Level level, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            BlockPos blockPos = hitResult.getBlockPos();
            level.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.5F + level.getRandom().nextFloat() * 1.2F);
            level.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + level.getRandom().nextFloat() * 1.2F);
        }
    }
}