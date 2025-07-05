package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class AmethystBrickStairsBlock extends StairsBlock implements AmethystChimeInterface {

    public AmethystBrickStairsBlock(BlockState blockState, Settings properties) {
        super(blockState, properties);
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(@NotNull World level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull ProjectileEntity projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }
}