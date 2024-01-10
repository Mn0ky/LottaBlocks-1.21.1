package net.ambersand.lottablocks.client;

import net.ambersand.lottablocks.registry.LottaBlocksRegistry;
import net.ambersand.lottablocks.registry.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.RenderType;
import net.ambersand.lottablocks.registry.blocks.ModBlocks;

@Environment(EnvType.CLIENT)
public class LottaBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // Renders Blocks in List as Transparent (Without Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
            ModBlocks.AMETHYST_FLOODLIGHT,
            ModBlocks.GLOW_GLASS,
            ModBlocks.GLOW_GLASS_PANE,
            ModBlocks.WALL_MOSS,
            ModBlocks.WALL_WEB,
            ModBlocks.CAST_IRON_DOOR,
            ModBlocks.CAST_IRON_TRAPDOOR
        );

        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
            ModBlocks.REINFORCED_GLASS,
            ModBlocks.REINFORCED_GLASS_PANE,
            ModBlocks.SOUL_GLASS,
            ModBlocks.SOUL_GLASS_PANE,
            ModBlocks.CONGEALED_PISS
        );

        // Luigite Item Packet (Lol)

        ClientPlayNetworking.registerGlobalReceiver(LottaBlocksRegistry.LUIGITE_PACKET_ID,((client, handler, buf, responseSender) ->
        client.gameRenderer.displayItemActivation(ModItems.LUIGITE_JUMPSCARE.getDefaultInstance())));
    }
}