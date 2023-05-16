package net.lunarluned.lottablocks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.lunarluned.lottablocks.block.ModBlocks;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class LottaBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // Renders Blocks in List as Transparent (Without Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.cutout(),

                ModBlocks.AMETHYST_FLOODLIGHT,
                ModBlocks.GLOW_GLASS

        );

        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.translucent(),

                ModBlocks.WALL_MOSS,
                ModBlocks.REINFORCED_GLASS,
                ModBlocks.SOUL_GLASS,
                ModBlocks.CONGEALED_PISS,
                ModBlocks.WALL_WEB
        );
    }
}