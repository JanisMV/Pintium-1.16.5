package fr.janis.pintium.client.render;

import fr.janis.pintium.client.model.BananatherModel;
import fr.janis.pintium.client.model.RatelModel;
import fr.janis.pintium.entities.BananatherEntity;
import fr.janis.pintium.entities.RatelEntity;
import fr.janis.pintium.main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BananatherRenderer extends MobRenderer<BananatherEntity, BananatherModel<BananatherEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(main.MODID, "textures/entity/bananather.png");

    public BananatherRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BananatherModel<>(), 0.4F);
    }

    @Override
    public ResourceLocation getEntityTexture(BananatherEntity entity) {
        return TEXTURE;
    }
}
