package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AmethystPillarBlock extends RotatedPillarBlock implements AmethystChimeInterface {

    public AmethystPillarBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull Projectile projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }
}