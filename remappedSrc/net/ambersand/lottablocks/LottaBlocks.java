package net.ambersand.lottablocks;

import net.fabricmc.api.ModInitializer;
import net.ambersand.lottablocks.registry.LottaBlocksRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class LottaBlocks implements ModInitializer {

	public static final String MOD_ID = "lottablocks";
	public static final Logger LOGGER = LoggerFactory.getLogger("Lotta Blocks");

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		LottaBlocksRegistry.registerAll();
		LOGGER.info("He's coming.");
	}

	// Compatibility

	public static final boolean HAS_ODYSSEY = FabricLoader.getInstance().isModLoaded("odyssey");
	public static final boolean HAS_ENDLESS_ENCORE = FabricLoader.getInstance().isModLoaded("endlessencore");
}