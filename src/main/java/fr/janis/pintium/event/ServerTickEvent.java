package fr.janis.pintium.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.time.Instant;
import java.util.Objects;
import java.util.Random;

public class ServerTickEvent {

    @SubscribeEvent
    public void onServerTickEvent(final TickEvent.ServerTickEvent e){

        Random dice = new Random();

        int posX;
        int posY;
        int posZ;

        posX = dice.nextInt(6);
        posY = dice.nextInt(6);
        posZ = dice.nextInt(6);

        MinecraftServer MServer = ServerLifecycleHooks.getCurrentServer();
        PlayerList plist = MServer.getPlayerList();
        for(PlayerEntity p : plist.getPlayers()) {

            if (p.getPersistentData().getBoolean("is_using_cannabis")){
                if (p.getPersistentData().getInt("is_using_cannabis_for") != 20*30){
                    HorseEntity entity = new HorseEntity(EntityType.HORSE, Objects.requireNonNull(p.getServer()).func_241755_D_());
                    entity.setPosition(p.getPosX() + posX, p.getPosY() + posY, p.getPosZ() + posZ);
                    Objects.requireNonNull(p.getServer()).func_241755_D_().addEntity(entity);
                    entity.remove();

                    int cannabis_used = p.getPersistentData().getInt("is_using_cannabis_for");

                    p.getPersistentData().putInt("is_using_cannabis_for", cannabis_used + 1);
                }
                else {
                    p.getPersistentData().putBoolean("is_using_cannabis", false);
                }
            }

            if (p.getPersistentData().getBoolean("inertium_is_used")) {
                if (p.getPosX() != p.getPersistentData().getDouble("posX") || p.getPosY() != p.getPersistentData().getDouble("posY") || p.getPosZ() != p.getPersistentData().getDouble("posZ")){
                    BlockPos pos = new BlockPos(p.getPersistentData().getDouble("posX") + 1, p.getPersistentData().getDouble("posY"), p.getPersistentData().getDouble("posZ") + 1);
                    p.getEntityWorld().removeBlock(pos, false);

                    Item ItemMainHand = BlockItem.getItemById(p.getPersistentData().getInt("ItemIDMH"));
                    Item ItemHead = Item.getItemById(p.getPersistentData().getInt("ItemIDHEAD"));
                    Item ItemChest = Item.getItemById(p.getPersistentData().getInt("ItemIDCHEST"));
                    Item ItemLeggings = Item.getItemById(p.getPersistentData().getInt("ItemIDLEGS"));
                    Item ItemBoots = Item.getItemById(p.getPersistentData().getInt("ItemIDFEET"));

                    ItemStack ItemMainHandStack = new ItemStack(ItemMainHand);
                    ItemMainHandStack.setCount(p.getPersistentData().getInt("number_of_block"));
                    p.addItemStackToInventory(ItemMainHandStack);

                    p.addItemStackToInventory(ItemHead.getDefaultInstance());
                    p.addItemStackToInventory(ItemChest.getDefaultInstance());
                    p.addItemStackToInventory(ItemLeggings.getDefaultInstance());
                    p.addItemStackToInventory(ItemBoots.getDefaultInstance());

                    p.removePotionEffect(Effects.STRENGTH);
                    p.removePotionEffect(Effects.HASTE);
                    p.removePotionEffect(Effects.SPEED);
                    Minecraft.getInstance().gameSettings.gamma = 1.0D;

                    p.removePotionEffect(Effects.INVISIBILITY);
                    p.getPersistentData().putBoolean("inertium_is_used", false);
                }
                else {
                    p.getPersistentData().putLong("inertium_use", Instant.now().getEpochSecond());
                    if (p.getPersistentData().getLong("inertium_cooldown") == p.getPersistentData().getLong("inertium_use")) {
                        p.getPersistentData().putBoolean("inertium_is_used", false);

                        BlockPos pos = new BlockPos(p.getPersistentData().getDouble("posX") + 1, p.getPersistentData().getDouble("posY"), p.getPersistentData().getDouble("posZ") + 1);
                        p.getEntityWorld().removeBlock(pos, false);

                        Item ItemMainHand = BlockItem.getItemById(p.getPersistentData().getInt("ItemIDMH"));
                        Item ItemHead = Item.getItemById(p.getPersistentData().getInt("ItemIDHEAD"));
                        Item ItemChest = Item.getItemById(p.getPersistentData().getInt("ItemIDCHEST"));
                        Item ItemLeggings = Item.getItemById(p.getPersistentData().getInt("ItemIDLEGS"));
                        Item ItemBoots = Item.getItemById(p.getPersistentData().getInt("ItemIDFEET"));

                        ItemStack ItemMainHandStack = new ItemStack(ItemMainHand);
                        ItemMainHandStack.setCount(p.getPersistentData().getInt("number_of_block"));
                        p.addItemStackToInventory(ItemMainHandStack);

                        p.addItemStackToInventory(ItemHead.getDefaultInstance());
                        p.addItemStackToInventory(ItemChest.getDefaultInstance());
                        p.addItemStackToInventory(ItemLeggings.getDefaultInstance());
                        p.addItemStackToInventory(ItemBoots.getDefaultInstance());

                        p.removePotionEffect(Effects.STRENGTH);
                        p.removePotionEffect(Effects.HASTE);
                        p.removePotionEffect(Effects.SPEED);
                        Minecraft.getInstance().gameSettings.gamma = 1.0D;

                        p.removePotionEffect(Effects.INVISIBILITY);
                    }
                }
            }
        }

    }
}   
