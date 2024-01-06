package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import org.jetbrains.annotations.NotNull;

public class WallWebBlock extends MultifaceBlock {

    public WallWebBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @NotNull MapCodec<WallWebBlock> codec() {
        return simpleCodec(WallWebBlock::new);
    }

    @SuppressWarnings("all")
    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}