package net.bball_262.breadbasket.blocks.custom;

import net.bball_262.breadbasket.blocks.BBblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import static net.bball_262.breadbasket.blocks.custom.ConvectionOvenBlock.FACING;

public class ConvectionOven extends Block {
    public ConvectionOven(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pPos = pContext.getClickedPos();
        BlockState pState = super.getStateForPlacement(pContext);
        if (pState == null) {
            return null;
        }
        pState.getValue(FACING);
        return super.getStateForPlacement(pContext);
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide) {
            Direction facing = pPlacer.getDirection().getOpposite();
            BlockPos topPos = pPos.above();
            BlockPos aboveTopPos = topPos.above();
            pLevel.setBlock(pPos, BBblocks.CONVECTION_OVEN_FURNACE.get().defaultBlockState(), 3);
            pLevel.setBlock(topPos, BBblocks.CONVECTION_OVEN_MAIN.get().defaultBlockState().setValue(FACING, facing), 3);
            pLevel.setBlock(aboveTopPos, BBblocks.CONVECTION_OVEN_PIPE.get().defaultBlockState().setValue(FACING, facing), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING});
    }
}