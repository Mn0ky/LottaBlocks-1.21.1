package net.ambersand.lottablocks.mixin;

import net.ambersand.lottablocks.LottaBlocks;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    // Puts a message in the server console to let the user know if a player has the mod installed

    @Inject(method = "placeNewPlayer", at = @At(value = "TAIL"))
    private void lottaBlocks$onPlayerConnectToServer(ClientConnection connection, ServerPlayerEntity serverPlayer, ConnectedClientData commonListenerCookie, CallbackInfo info) {
        LottaBlocks.LOGGER.info(serverPlayer.getName().getString() + " has " + LottaBlocks.LOGGER.getName() + " installed");
    }
}