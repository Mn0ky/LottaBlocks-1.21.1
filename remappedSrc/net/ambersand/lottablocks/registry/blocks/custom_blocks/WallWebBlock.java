package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;
import org.jetbrains.annotations.NotNull;

public class WallWebBlock extends MultifaceGrowthBlock {

    public WallWebBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @NotNull MapCodec<WallWebBlock> getCodec() {
        return createCodec(WallWebBlock::new);
    }

    @SuppressWarnings("all")
    @Override
    public LichenGrower getGrower() {
        return null;
    }
}