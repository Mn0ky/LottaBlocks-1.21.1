package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AmethystBrickStairsBlock extends StairBlock implements AmethystChimeInterface {

    public AmethystBrickStairsBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull Projectile projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }
}