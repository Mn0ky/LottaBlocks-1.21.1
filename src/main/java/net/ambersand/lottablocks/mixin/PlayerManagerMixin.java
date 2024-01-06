package net.ambersand.lottablocks.mixin;

import net.ambersand.lottablocks.LottaBlocks;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerList.class)
public class PlayerManagerMixin {

    // Puts a message in the server console to let the user know if a player has the mod installed

    @Inject(method = "placeNewPlayer", at = @At(value = "TAIL"))
    private void lottaBlocks$onPlayerConnectToServer(Connection connection, ServerPlayer serverPlayer, CommonListenerCookie commonListenerCookie, CallbackInfo info) {
        LottaBlocks.LOGGER.info(serverPlayer.getName().getString() + " has " + LottaBlocks.LOGGER.getName() + " installed");
    }
}