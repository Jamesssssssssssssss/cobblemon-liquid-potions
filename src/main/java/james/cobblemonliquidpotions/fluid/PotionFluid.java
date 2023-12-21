package james.cobblemonliquidpotions.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class PotionFluid extends FlowableFluid {
	@Override
	protected boolean isInfinite(World var1) {
		return false;
	}
	
    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }
    
    @Override
    protected boolean canBeReplacedWith(FluidState var1, BlockView var2, BlockPos var3, Fluid var4, Direction var5) {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    @Override
    protected int getFlowSpeed(WorldView var1) {
    	return 4;
    }
    
    @Override
    protected int getLevelDecreasePerBlock(WorldView var1) {
    	return 1;
    }
    
    @Override
    public int getLevel(FluidState var1) {
    	return 8;
    }
    
    @Override
    public int getTickRate(WorldView var1) {
    	return 5;
    }
    
    @Override
    protected float getBlastResistance() {
    	return 100f;
    }
    
    @Override
    public Fluid getStill() {
    	return ModFluids.STILL_POTION;
    }
    
    @Override
    public Fluid getFlowing() {
    	return ModFluids.FLOWING_POTION;
    }
    
    @Override
    public Item getBucketItem() {
    	return ModFluids.POTION_BUCKET;
    }
    
    @Override
    protected BlockState toBlockState(FluidState var1) {
    	return ModFluids.POTION_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(var1));
    }
    
    @Override
    public boolean isStill(FluidState var1) {
    	return false;
    }

    public static class Flowing
    extends PotionFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still
    extends PotionFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
