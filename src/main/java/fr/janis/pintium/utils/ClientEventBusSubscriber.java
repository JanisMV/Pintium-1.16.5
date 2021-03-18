package fr.janis.pintium.utils;

import fr.janis.pintium.client.render.BananoFishRenderer;
import fr.janis.pintium.client.render.BananosaurRenderer;
import fr.janis.pintium.client.render.RatelRenderer;
import fr.janis.pintium.client.render.TunaRenderer;
import fr.janis.pintium.init.PintiumEntities;
import fr.janis.pintium.items.PintiumSpawnEggItem;
import fr.janis.pintium.main;
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
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.BANANOSAUR.get(), BananosaurRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.TUNA.get(), TunaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PintiumEntities.BANANOFISH.get(), BananoFishRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> e){
        PintiumSpawnEggItem.initSpawnEggs();
    }
}
