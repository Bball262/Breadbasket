package net.bball_262.breadbasket.blocks.custom;

import net.bball_262.breadbasket.blocks.BBblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ConvectionOven extends Block {
    public ConvectionOven(Properties pProperties) {
        super(pProperties);
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide) {
            BlockPos topPos = pPos.above();
            BlockPos aboveTopPos = topPos.above();
            pLevel.setBlock(pPos, BBblocks.CONVECTION_OVEN_FURNACE.get().defaultBlockState(), 3);
            pLevel.setBlock(topPos, BBblocks.CONVECTION_OVEN_MAIN.get().defaultBlockState(), 3);
            pLevel.setBlock(aboveTopPos, BBblocks.CONVECTION_OVEN_PIPE.get().defaultBlockState(), 3);
        }
    }
}