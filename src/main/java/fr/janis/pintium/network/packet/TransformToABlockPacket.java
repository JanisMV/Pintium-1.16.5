package fr.janis.pintium.network.packet;

import fr.janis.pintium.init.PintiumItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.time.Instant;
import java.util.function.Supplier;

public class TransformToABlockPacket {
    public TransformToABlockPacket()
    {
    }

    public static void encode(TransformToABlockPacket packet, PacketBuffer buffer){
    }

    public static TransformToABlockPacket decode(PacketBuffer buffer)
    {
        return new TransformToABlockPacket();
    }

    public static void handle(TransformToABlockPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        ServerPlayerEntity p = ctxProvider.get().getSender();
        ServerWorld world = ctxProvider.get().getSender().getServerWorld();
        CompoundNBT dataP = p.getPersistentData();

        if (world != null && p != null){
            p.getPersistentData().putLong("inertium_use", Instant.now().getEpochSecond());

            if (p.getPersistentData().getLong("inertium_cooldown") <= p.getPersistentData().getLong("inertium_use")) {
                if (p.getHeldItemMainhand().getItem() instanceof BlockItem){
                    dataP.putLong("inertium_cooldown", Instant.now().getEpochSecond() + 30);
                    dataP.putBoolean("inertium_is_used", true);
                    BlockPos posBlock = new BlockPos(p.getPosX() + 1, p.getPosY(), p.getPosZ() + 1);
                    dataP.putDouble("posX", p.getPosX());
                    dataP.putDouble("posY", p.getPosY());
                    dataP.putDouble("posZ", p.getPosZ());

                    dataP.putInt("number_of_block", p.getHeldItemMainhand().getCount());
                    world.setBlockState(posBlock, ((BlockItem) p.getHeldItemMainhand().getItem()).getBlock().getDefaultState());

                    dataP.putInt("ItemIDMH", BlockItem.getIdFromItem(p.getHeldItemMainhand().getItem()));
                    dataP.putInt("ItemIDHEAD", BlockItem.getIdFromItem(p.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem()));
                    dataP.putInt("ItemIDCHEST", BlockItem.getIdFromItem(p.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem()));
                    dataP.putInt("ItemIDLEGS", BlockItem.getIdFromItem(p.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem()));
                    dataP.putInt("ItemIDFEET", BlockItem.getIdFromItem(p.getItemStackFromSlot(EquipmentSlotType.FEET).getItem()));

                    p.inventory.deleteStack(p.getHeldItemMainhand().getStack());
                    p.inventory.deleteStack(p.getItemStackFromSlot(EquipmentSlotType.HEAD));
                    p.inventory.deleteStack(p.getItemStackFromSlot(EquipmentSlotType.CHEST));
                    p.inventory.deleteStack(p.getItemStackFromSlot(EquipmentSlotType.LEGS));
                    p.inventory.deleteStack(p.getItemStackFromSlot(EquipmentSlotType.FEET));
                    
                    if (p.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() != PintiumItems.PINTIUM_HELMET.get() || p.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() != PintiumItems.PINTIUM_CHESTPLATE.get() || p.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() != PintiumItems.PINTIUM_LEGGINGS.get() || p.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() != PintiumItems.PINTIUM_BOOTS.get()){
                        p.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 20*99999999, 1));
                    }
                    else{
                        if (p.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == PintiumItems.PINTIUM_HELMET.get()){
                            Minecraft.getInstance().gameSettings.gamma = 1.0D;
                        }
                        else if (p.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == PintiumItems.PINTIUM_CHESTPLATE.get()){
                            p.removePotionEffect(Effects.STRENGTH);
                        }
                        else if (p.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == PintiumItems.PINTIUM_LEGGINGS.get()){
                            p.removePotionEffect(Effects.HASTE);
                        }
                        else if (p.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == PintiumItems.PINTIUM_BOOTS.get()){
                            p.removePotionEffect(Effects.SPEED);
                        }
                    }
                    ctxProvider.get().setPacketHandled(true);
                }
                else {
                    String text = new TranslationTextComponent("pintium.guispells.inertium.no_block_in_hand").getString();
                    p.sendStatusMessage(ITextComponent.getTextComponentOrEmpty((text)), true);
                }
            }
            else {
                String text = new TranslationTextComponent("pintium.guispells.cooldown_not_finished1").getString() + (p.getPersistentData().getLong("inertium_cooldown") - p.getPersistentData().getLong("inertium_use")) + new TranslationTextComponent("pintium.guispells.cooldown_not_finished2").getString();
                p.sendStatusMessage(ITextComponent.getTextComponentOrEmpty((text)), true);
            }
        ctxProvider.get().setPacketHandled(true);
        }
    }
}