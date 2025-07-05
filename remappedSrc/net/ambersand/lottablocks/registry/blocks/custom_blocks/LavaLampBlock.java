package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class LavaLampBlock extends PillarBlock {

    public LavaLampBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(@NotNull BlockState blockState, @NotNull World level, @NotNull BlockPos blockPos, Random randomSource) {
        if (randomSource.nextInt(200) == 0) {
            level.playSound((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 1.0F, randomSource.nextFloat() * 0.4F + 0.8F, false);
        }
    }
}