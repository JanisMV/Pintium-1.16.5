package fr.janis.pintium.items;

import fr.janis.pintium.utils.CustomPintiumTiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PintiumHammer extends PickaxeItem {
    public PintiumHammer(Properties properties) {
        super(CustomPintiumTiers.PINTIUM, 8, -3.5f, properties);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

        if (entityLiving.getHorizontalFacing() == Direction.NORTH || entityLiving.getHorizontalFacing() == Direction.SOUTH){

            BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            BlockPos pos5 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
            BlockPos pos6 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
            BlockPos pos7 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ());
            BlockPos pos8 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ());

            if (worldIn.getBlockState(pos1).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos1, true);
            }
            if (worldIn.getBlockState(pos2).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos2, true);
            }
            if (worldIn.getBlockState(pos3).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos3, true);
            }
            if (worldIn.getBlockState(pos4).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos4, true);
            }
            if (worldIn.getBlockState(pos5).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos5, true);
            }
            if (worldIn.getBlockState(pos6).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos6, true);
            }
            if (worldIn.getBlockState(pos7).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos7, true);
            }
            if (worldIn.getBlockState(pos8).getBlock().asItem() != Items.BEDROCK) {
                worldIn.destroyBlock(pos8, true);
            }
        }
        else if (entityLiving.getHorizontalFacing() == Direction.EAST || entityLiving.getHorizontalFacing() == Direction.WEST){

            BlockPos pos1 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
            BlockPos pos2 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
            BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
            BlockPos pos7 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1);
            BlockPos pos8 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1);

            if (worldIn.getBlockState(pos1).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos1, true);
            }
            if (worldIn.getBlockState(pos2).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos2, true);
            }
            if (worldIn.getBlockState(pos3).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos3, true);
            }
            if (worldIn.getBlockState(pos4).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos4, true);
            }
            if (worldIn.getBlockState(pos5).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos5, true);
            }
            if (worldIn.getBlockState(pos6).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos6, true);
            }
            if (worldIn.getBlockState(pos7).getBlock().asItem() != Items.BEDROCK){
                worldIn.destroyBlock(pos7, true);
            }
            if (worldIn.getBlockState(pos8).getBlock().asItem() != Items.BEDROCK) {
                worldIn.destroyBlock(pos8, true);
            }
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
