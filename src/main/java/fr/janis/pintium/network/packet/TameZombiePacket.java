package fr.janis.pintium.network.packet;

import fr.janis.pintium.entities.RatelBodyGuardEntity;
import fr.janis.pintium.entities.ZombieBodyGuardEntity;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TameZombiePacket {

    public TameZombiePacket()
    {
    }

    public static void encode(TameZombiePacket packet, PacketBuffer buffer)
    {
    }

    public static TameZombiePacket decode(PacketBuffer buffer)
    {
        return new TameZombiePacket();
    }

    public static void handle(TameZombiePacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        ZombieBodyGuardEntity zombie = new ZombieBodyGuardEntity(PintiumEntities.ZOMBIE_BODY_GUARD.get(), ctxProvider.get().getSender().getServerWorld());

        zombie.setPosition(ctxProvider.get().getSender().getPosX(), ctxProvider.get().getSender().getPosY(), ctxProvider.get().getSender().getPosZ());

        ctxProvider.get().getSender().getServerWorld().addEntity(zombie);

        ctxProvider.get().setPacketHandled(true);
    }
}