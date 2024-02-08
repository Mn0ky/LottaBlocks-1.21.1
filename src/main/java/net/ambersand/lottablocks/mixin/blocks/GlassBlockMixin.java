package net.ambersand.lottablocks.mixin.blocks;

import net.ambersand.lottablocks.registry.misc.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HalfTransparentBlock.class)
public class GlassBlockMixin extends Block {

    private GlassBlockMixin(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Inject(at = @At("HEAD"), method = "skipRendering", cancellable = true)
    private void lottaBlocks$occludeGlassFaces(BlockState blockState, BlockState adjacentBlock, Direction direction, CallbackInfoReturnable<Boolean> cir) {

        TagKey<Block> occludingGlass = ModTags.OCCLUDING_GLASS;

        if (blockState.is(occludingGlass)) cir.setReturnValue(adjacentBlock.is(occludingGlass) || super.skipRendering(blockState, adjacentBlock, direction));
    }
}