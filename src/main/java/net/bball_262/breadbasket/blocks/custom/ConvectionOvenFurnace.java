package net.bball_262.breadbasket.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ConvectionOvenFurnace extends Block {
    public ConvectionOvenFurnace(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        super.destroy(pLevel, pPos, pState);
        BlockPos topPos = pPos.above();
        BlockPos aboveTopPos = topPos.above();

        pLevel.destroyBlock(topPos, false);
        pLevel.destroyBlock(aboveTopPos, false);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
        BlockPos topPos = pPos.above();
        BlockPos aboveTopPos = topPos.above();

        pLevel.destroyBlock(topPos, false, pPlayer);
        pLevel.destroyBlock(aboveTopPos, false, pPlayer);
    }
}
