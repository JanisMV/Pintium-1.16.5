package fr.janis.pintium.client.render;

import fr.janis.pintium.client.model.RatelModel;
import fr.janis.pintium.entities.RatelEntity;
import fr.janis.pintium.main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RatelRenderer extends MobRenderer<RatelEntity, RatelModel<RatelEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(main.MODID, "textures/entity/ratel.png");

    public RatelRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RatelModel<>(), 0.4F);
    }

    @Override
    public ResourceLocation getEntityTexture(RatelEntity entity) {
        return TEXTURE;
    }
}
