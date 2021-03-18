package fr.janis.pintium.client.render;

import fr.janis.pintium.client.model.BananosaurModel;
import fr.janis.pintium.entities.BananosaurEntity;
import fr.janis.pintium.main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BananosaurRenderer extends MobRenderer<BananosaurEntity, BananosaurModel<BananosaurEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(main.MODID, "textures/entity/bananosaur.png");

    public BananosaurRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BananosaurModel<>(), 0.4F);
    }

    @Override
    public ResourceLocation getEntityTexture(BananosaurEntity entity) {
        return TEXTURE;
    }
}
