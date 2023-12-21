package james.cobblemonliquidpotions;

import james.cobblemonliquidpotions.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class CobblemonLiquidPotionsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_POTION, ModFluids.FLOWING_POTION, new SimpleFluidRenderHandler(new Identifier("minecraft:block/water_still"), new Identifier("minecraft:block/water_flow"), 0xA1794DB3));
		
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_POTION, ModFluids.FLOWING_POTION);
	}
}