package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;

public class WallWebBlock extends MultifaceBlock {

    public WallWebBlock(Properties settings) {
        super(settings);
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}