package fr.janis.pintium.event;

import fr.janis.pintium.init.PintiumItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;



public class ArmorEvents {
    @SubscribeEvent
    public void onPlayerEquipmentChange(final LivingEquipmentChangeEvent e){
        if(e.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = ((PlayerEntity) e.getEntityLiving());

            if (!player.getPersistentData().getBoolean("inertium_is_used")) {
                if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == PintiumItems.PINTIUM_HELMET.get() && Minecraft.getInstance().gameSettings.gamma == 1.0D) {
                    Minecraft.getInstance().gameSettings.gamma = 9.0D;
                } else if (e.getFrom().getItem() == PintiumItems.PINTIUM_HELMET.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty() && Minecraft.getInstance().gameSettings.gamma == 9.0D) {
                    Minecraft.getInstance().gameSettings.gamma = 1.0D;
                }

                if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == PintiumItems.PINTIUM_CHESTPLATE.get() && !player.isPotionActive(Effects.STRENGTH)) {
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 20 * 99999999, 0));
                } else if (e.getFrom().getItem() == PintiumItems.PINTIUM_CHESTPLATE.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() && player.isPotionActive(Effects.STRENGTH)) {
                    player.removePotionEffect(Effects.STRENGTH);
                }

                if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == PintiumItems.PINTIUM_LEGGINGS.get() && !player.isPotionActive(Effects.HASTE)) {
                    player.addPotionEffect(new EffectInstance(Effects.HASTE, 20 * 99999999, 0));
                } else if (e.getFrom().getItem() == PintiumItems.PINTIUM_LEGGINGS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty() && player.isPotionActive(Effects.HASTE)) {
                    player.removePotionEffect(Effects.HASTE);
                }

                if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == PintiumItems.PINTIUM_BOOTS.get() && !player.isPotionActive(Effects.SPEED)) {
                    player.addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 99999999, 0));
                } else if (e.getFrom().getItem() == PintiumItems.PINTIUM_BOOTS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() && player.isPotionActive(Effects.SPEED)) {
                    player.removePotionEffect(Effects.SPEED);
                }

                if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == PintiumItems.PINTIUM_HELMET.get()
                        && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == PintiumItems.PINTIUM_CHESTPLATE.get()
                        && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == PintiumItems.PINTIUM_LEGGINGS.get()
                        && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == PintiumItems.PINTIUM_BOOTS.get()
                        && !player.isPotionActive(Effects.INVISIBILITY)) {
                    player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 20 * 99999999, 1));
                } else if (e.getFrom().getItem() == PintiumItems.PINTIUM_HELMET.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
                        e.getFrom().getItem() == PintiumItems.PINTIUM_CHESTPLATE.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
                        e.getFrom().getItem() == PintiumItems.PINTIUM_LEGGINGS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
                        e.getFrom().getItem() == PintiumItems.PINTIUM_BOOTS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() && player.isPotionActive(Effects.INVISIBILITY)) {
                    player.removePotionEffect(Effects.INVISIBILITY);
                }
            }
        }
    }
}