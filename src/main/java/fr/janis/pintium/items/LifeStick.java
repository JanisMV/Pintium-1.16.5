package fr.janis.pintium.items;

import fr.janis.pintium.gui.SpellsGui;
import fr.janis.pintium.gui.TameMobs;
import fr.janis.pintium.network.Network;
import fr.janis.pintium.network.packet.TameRatelPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class LifeStick extends Item {
    public LifeStick(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)){
            tooltip.add(new TranslationTextComponent("tooltip.life_stick.hold_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.life_stick.not_hold_shift"));
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        Minecraft.getInstance().displayGuiScreen(new TameMobs());

        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }

}
