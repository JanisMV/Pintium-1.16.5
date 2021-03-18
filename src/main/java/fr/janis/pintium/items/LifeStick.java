package fr.janis.pintium.items;

import fr.janis.pintium.data.CapabilityEntityKilled;
import fr.janis.pintium.init.PintiumEntities;
import fr.janis.pintium.init.PintiumItems;
import fr.janis.pintium.main;
import fr.janis.pintium.network.Network;
import fr.janis.pintium.network.packet.TameCreeperPacket;
import fr.janis.pintium.network.packet.TameRatelPacket;
import fr.janis.pintium.network.packet.TameSkeletonPacket;
import fr.janis.pintium.network.packet.TameZombiePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
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
        playerIn.getCapability(CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY).ifPresent(h -> {
            main.LOGGER.debug(h.getName());
            if (h.getName() != null){
                main.LOGGER.debug(h.getName() + "n'est pas null");
                if (h.getName().equals(PintiumEntities.RATEL.get().getName().getString()))
                {
                    if (playerIn.inventory.hasItemStack(new ItemStack(PintiumItems.HEAL_ORB.get()))) {
                        playerIn.inventory.deleteStack(new ItemStack(PintiumItems.HEAL_ORB.get()));

                        Network.CHANNEL.sendToServer(new TameRatelPacket());
                        h.setName(null);
                    }
                }
                else if (h.getName().equals(EntityType.ZOMBIE.getName().getString())){
                    if (playerIn.inventory.hasItemStack(new ItemStack(PintiumItems.HEAL_ORB.get()))) {
                        playerIn.inventory.deleteStack(new ItemStack(PintiumItems.HEAL_ORB.get()));

                        Network.CHANNEL.sendToServer(new TameZombiePacket());
                        h.setName(null);
                    }
                }

                else if (h.getName().equals(EntityType.SKELETON.getName().getString())){
                    if (playerIn.inventory.hasItemStack(new ItemStack(PintiumItems.HEAL_ORB.get()))){
                        playerIn.inventory.deleteStack(new ItemStack(PintiumItems.HEAL_ORB.get()));

                        Network.CHANNEL.sendToServer(new TameSkeletonPacket());
                        h.setName(null);
                    }
                }
                
                else if (h.getName().equals(EntityType.CREEPER.getName().getString())){
                    if (playerIn.inventory.hasItemStack(new ItemStack(PintiumItems.HEAL_ORB.get()))){
                        playerIn.inventory.deleteStack(new ItemStack(PintiumItems.HEAL_ORB.get()));

                        Network.CHANNEL.sendToServer(new TameCreeperPacket());
                        h.setName(null);
                    }
                }
            }
        });

        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }

}
