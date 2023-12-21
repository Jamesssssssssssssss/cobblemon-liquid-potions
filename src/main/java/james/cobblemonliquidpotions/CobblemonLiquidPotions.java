package james.cobblemonliquidpotions;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import james.cobblemonliquidpotions.fluid.ModFluids;

public class CobblemonLiquidPotions implements ModInitializer {
	public static final String MOD_ID = "cobblemon-liquid-potions";
    public static final Logger LOGGER = LoggerFactory.getLogger("cobblemon-liquid-potions");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModFluids.register();
	}
}