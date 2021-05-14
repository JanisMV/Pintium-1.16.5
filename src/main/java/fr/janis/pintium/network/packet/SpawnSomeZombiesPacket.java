package fr.janis.pintium.network.packet;

import fr.janis.pintium.entities.ZombieBodyGuardEntity;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.time.Instant;
import java.util.function.Supplier;

public class SpawnSomeZombiesPacket {

    public SpawnSomeZombiesPacket()
    {
    }

    public static void encode(SpawnSomeZombiesPacket packet, PacketBuffer buffer)
    {
    }

    public static SpawnSomeZombiesPacket decode(PacketBuffer buffer)
    {
        return new SpawnSomeZombiesPacket();
    }

    public static void handle(SpawnSomeZombiesPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        ServerPlayerEntity p = ctxProvider.get().getSender();
        p.getPersistentData().putLong("zombium_use", Instant.now().getEpochSecond());

        if (p.getPersistentData().getLong("zombium_cooldown") <= p.getPersistentData().getLong("zombium_use")) {

            p.getPersistentData().putLong("zombium_cooldown", Instant.now().getEpochSecond() + 30);

            int i;
            for (i = 0; i < 5; i++) {

                ZombieBodyGuardEntity entity = new ZombieBodyGuardEntity(PintiumEntities.ZOMBIE_BODY_GUARD.get(), p.getServerWorld());
                entity.setPosition(p.getPosX(), p.getPosY(), p.getPosZ());
                entity.setCustomName(new TranslationTextComponent("pintium.guispells.zombium.zombieName"));
                entity.setChild(true);
                entity.setAttackTarget(p.getLastAttackedEntity());
                p.getServerWorld().addEntity(entity);
            }
            ctxProvider.get().setPacketHandled(true);
        }
        else {
            String text = new TranslationTextComponent("pintium.guispells.cooldown_not_finished1").getString() + (p.getPersistentData().getLong("zombium_cooldown") - p.getPersistentData().getLong("zombium_use")) + new TranslationTextComponent("pintium.guispells.cooldown_not_finished2").getString();
            p.sendStatusMessage(ITextComponent.getTextComponentOrEmpty((text)), true);
        }
        ctxProvider.get().setPacketHandled(true);
    }
}