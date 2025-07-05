package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface AmethystChimeInterface {

    default void playChimeSounds(World level, BlockHitResult hitResult) {
        if (!level.isClient()) {
            BlockPos blockPos = hitResult.getBlockPos();
            level.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1.0F, 0.5F + level.getRandom().nextFloat() * 1.2F);
            level.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0F, 0.5F + level.getRandom().nextFloat() * 1.2F);
        }
    }
}