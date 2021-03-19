package fr.janis.pintium.blocks;

import fr.janis.pintium.entities.BananatherEntity;
import fr.janis.pintium.entities.RatelEntity;
import fr.janis.pintium.init.PintiumBlocks;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BananaBlock extends Block {
    public BananaBlock() {
        super(AbstractBlock.Properties.create(Material.CACTUS).harvestTool(ToolType.SHOVEL).setRequiresTool());
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        // Block block = worldIn.getBlockState(pos).getBlock();
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        if (worldIn.getBlockState(pos).getBlock() == PintiumBlocks.BANANA_BLOCK.get()
                && worldIn.getBlockState(pos1).getBlock() == PintiumBlocks.BANANA_BLOCK.get()
                && worldIn.getBlockState(pos2).getBlock() == PintiumBlocks.BANANA_BLOCK.get()
                && worldIn.getBlockState(pos3).getBlock() == PintiumBlocks.BANANA_BLOCK.get()
        ){
            BananatherEntity boss = new BananatherEntity(PintiumEntities.BANANATHER.get(), worldIn);

            boss.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());

            worldIn.addEntity(boss);

            worldIn.removeBlock(pos, false);
            worldIn.removeBlock(pos1, false);
            worldIn.removeBlock(pos2, false);
            worldIn.removeBlock(pos3, false);
        }
    }
}
