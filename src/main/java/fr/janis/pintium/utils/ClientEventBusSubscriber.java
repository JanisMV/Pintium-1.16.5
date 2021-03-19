package fr.janis.pintium.utils;

import fr.janis.pintium.client.render.*;
import fr.janis.pintium.init.PintiumEntities;
import fr.janis.pintium.items.PintiumSpawnEggItem;
import fr.janis.pintium.main;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e){
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.RATEL.get(), RatelRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.RATEL_BODY_GUARD.get(), RatelRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.ZOMBIE_BODY_GUARD.get(), ZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.SKELETON_BODY_GUARD.get(), SkeletonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.CREEPER_BODY_GUARD.get(), CreeperRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.BANANOSAUR.get(), BananosaurRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.TUNA.get(), TunaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.BANANATHER.get(), BananatherRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.BANANOFISH.get(), BananoFishRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> e){
        PintiumSpawnEggItem.initSpawnEggs();
    }
}
