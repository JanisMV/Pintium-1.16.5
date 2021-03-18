package fr.janis.pintium.network.packet;

import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.time.Instant;
import java.util.function.Supplier;

public class SpawnABoatPacket {

    public SpawnABoatPacket()
    {
    }

    public static void encode(SpawnABoatPacket packet, PacketBuffer buffer)
    {
    }

    public static SpawnABoatPacket decode(PacketBuffer buffer)
    {
        return new SpawnABoatPacket();
    }

    public static void handle(SpawnABoatPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        ServerPlayerEntity p = ctxProvider.get().getSender();
        p.getPersistentData().putLong("batum_use", Instant.now().getEpochSecond());

        if (p.getPersistentData().getLong("batum_cooldown") <= p.getPersistentData().getLong("batum_use")) {

            p.getPersistentData().putLong("batum_cooldown", Instant.now().getEpochSecond() + 30);
            BoatEntity entity = new BoatEntity(p.getServerWorld(), p.getPosX() + 1, p.getPosY(), p.getPosZ());
            p.getServerWorld().addEntity(entity);
            ctxProvider.get().setPacketHandled(true);

        }
        ctxProvider.get().setPacketHandled(true);
    }
}