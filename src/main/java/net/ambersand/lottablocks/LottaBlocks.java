package net.ambersand.lottablocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ambersand.lottablocks.registry.LottaBlocksRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class LottaBlocks implements ModInitializer {

	public static final String MOD_ID = "lottablocks";
	public static final Logger LOGGER = LoggerFactory.getLogger("Lotta Blocks");

	// Updated for 1.21.1. Direct constructers for ResourceLocation are now private, using factory method instead
	public static ResourceLocation id(String name) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		LottaBlocksRegistry.registerAll();
		LOGGER.info("lottablocks loaded!!");
	}

	// Compatibility

	public static final boolean HAS_ODYSSEY = FabricLoader.getInstance().isModLoaded("odyssey");
	public static final boolean HAS_ENDLESS_ENCORE = FabricLoader.getInstance().isModLoaded("endlessencore");
}