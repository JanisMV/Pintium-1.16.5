package fr.janis.pintium.network.packet;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.time.Instant;
import java.util.function.Supplier;
import java.util.Random;

public class CannabisPacket {

    public CannabisPacket()
    {
    }

    public static void encode(CannabisPacket packet, PacketBuffer buffer)
    {
    }

    public static CannabisPacket decode(PacketBuffer buffer)
    {
        return new CannabisPacket();
    }

    public static void handle(CannabisPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        Random dice = new Random();
        int posX;
        int posY;
        int posZ;

        posX = dice.nextInt(6);
        posY = dice.nextInt(6);
        posZ = dice.nextInt(6);

        ServerPlayerEntity p = ctxProvider.get().getSender();
        p.getPersistentData().putLong("cannabis_use", Instant.now().getEpochSecond());

        if (p.getPersistentData().getLong("cannabis_cooldown") <= p.getPersistentData().getLong("cannabis_use")) {

            p.getPersistentData().putLong("cannabis_cooldown", Instant.now().getEpochSecond() + 30);

            HorseEntity entity = new HorseEntity(EntityType.HORSE, p.getServerWorld());
            entity.setPosition(p.getPosX() + posX, p.getPosY() + posY, p.getPosZ() + posZ);
            p.getServerWorld().addEntity(entity);
            entity.remove();

            p.getPersistentData().putBoolean("is_using_cannabis", true);
            p.getPersistentData().putInt("is_using_cannabis_for", 1);

            ctxProvider.get().setPacketHandled(true);
        }
        ctxProvider.get().setPacketHandled(true);
    }
}