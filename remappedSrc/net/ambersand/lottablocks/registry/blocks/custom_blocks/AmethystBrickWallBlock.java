package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class AmethystBrickWallBlock extends WallBlock implements AmethystChimeInterface {

    public AmethystBrickWallBlock(Settings properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(@NotNull World level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull ProjectileEntity projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }
}