package fr.janis.pintium;

import fr.janis.pintium.data.CapabilityEntityKilled;
import fr.janis.pintium.data.CapabilityEntityKilledEventHandler;
import fr.janis.pintium.data.onEntityDeathEvent;
import fr.janis.pintium.entities.*;
import fr.janis.pintium.event.*;
import fr.janis.pintium.init.*;

import fr.janis.pintium.keybind.KeyBinds;
import fr.janis.pintium.network.Network;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Gravity Gun
// Système de level
// Ajouter des structures
// Créer un disque avec des musiques
// Inertium si inventaire full et armure, armure perdue :sob:
// Quand Cannabis consommé direction du joueur changé + craft impossible + rajouter des animaux à la vision
// Modifier loot Hautes Herbes (Global Loot Modifier), Et mettre une proba d'avoir des graines
// Rajouter Boss qui se build comme le wither avec new mob + new block

@Mod(main.MODID)
public class main
{
    public static final String MODID = "pintium";
    public static final Logger LOGGER = LogManager.getLogger();

    public main(){

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        PintiumItems.ITEMS.register(bus);
        PintiumBlocks.BLOCKS.register(bus);
        PintiumTileEntities.TILE_ENTITIES.register(bus);
        PintiumEntities.ENTITY_TYPES.register(bus);

    }

    private void setup(FMLCommonSetupEvent e){
        PintiumFeatures features = new PintiumFeatures();

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PintiumEntities.RATEL.get(), RatelEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(PintiumEntities.RATEL_BODY_GUARD.get(), RatelBodyGuardEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(PintiumEntities.BANANOSAUR.get(), BananosaurEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(PintiumEntities.TUNA.get(), TunaEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(PintiumEntities.BANANOFISH.get(), BananoFishEntity.setCustomAttributes().create());
        });

        Network.registerNetworkPackets();
        CapabilityEntityKilled.register();

        features.init();

        MinecraftForge.EVENT_BUS.register(features);
        MinecraftForge.EVENT_BUS.register(new FallingEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorEvents());
        MinecraftForge.EVENT_BUS.register(new TickEvent());
        MinecraftForge.EVENT_BUS.register(new ServerTickEvent());
        MinecraftForge.EVENT_BUS.register(new UsedItemEvent());
        MinecraftForge.EVENT_BUS.register(new onEntityDeathEvent());
        MinecraftForge.EVENT_BUS.register(CapabilityEntityKilledEventHandler.class);

        KeyBinds.register();

        MinecraftForge.EVENT_BUS.register(new KeyBindEvent());
    }

    private void clientSetup(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(PintiumBlocks.PINTIUM_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PintiumBlocks.CANNABIS_CROP.get(), RenderType.getCutout());
    }
}