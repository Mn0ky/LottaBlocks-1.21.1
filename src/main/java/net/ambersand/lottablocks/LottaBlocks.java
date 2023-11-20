package net.ambersand.lottablocks;

import net.fabricmc.api.ModInitializer;
import net.ambersand.lottablocks.registry.LottaBlocksRegistry;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LottaBlocks implements ModInitializer {

	public static final String MOD_ID = "lottablocks";
	public static final Logger LOGGER = LoggerFactory.getLogger("Lotta Blocks");

	public static ResourceLocation id(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		LottaBlocksRegistry.registerAll();
		LOGGER.info("He's coming.");
	}
}