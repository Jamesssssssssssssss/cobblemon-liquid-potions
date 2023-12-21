package james.cobblemonliquidpotions.fluid;

import james.cobblemonliquidpotions.CobblemonLiquidPotions;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
	public static FlowableFluid STILL_POTION;
	public static FlowableFluid FLOWING_POTION;
	public static Block POTION_BLOCK;
	public static Item POTION_BUCKET;
	
	public static void register() {
		STILL_POTION = Registry.register(Registries.FLUID, new Identifier(CobblemonLiquidPotions.MOD_ID, "potion"), new PotionFluid.Still());
		FLOWING_POTION = Registry.register(Registries.FLUID, new Identifier(CobblemonLiquidPotions.MOD_ID, "flowing_potion"), new PotionFluid.Flowing());
		
		POTION_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CobblemonLiquidPotions.MOD_ID, "potion_block"), new FluidBlock(ModFluids.STILL_POTION, FabricBlockSettings.copyOf(Blocks.WATER)));
		POTION_BUCKET = Registry.register(Registries.ITEM, new Identifier(CobblemonLiquidPotions.MOD_ID, "potion_bucket"), new BucketItem(ModFluids.STILL_POTION, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
	}
}
