package fr.janis.pintium.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.janis.pintium.entities.RatelEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class RatelModel<T extends RatelEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer body_rotation;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tail;
    private final ModelRenderer tail_rotation;

    public RatelModel() {
        textureWidth = 48;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(1.0F, 16.5F, -3.0F);
        head.setTextureOffset(1, 5).addBox(-5.0F, -2.0F, -5.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(6, 18).addBox(-3.0F, 2.0F, -8.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 7.5F, 3.5F);


        body_rotation = new ModelRenderer(this);
        body_rotation.setRotationPoint(0.0F, 9.5F, -1.5F);
        body.addChild(body_rotation);
        setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);
        body_rotation.setTextureOffset(24, 15).addBox(-3.0F, -4.5F, -2.0F, 6.0F, 11.0F, 4.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(5.0F, 17.5F, 7.0F);
        leg1.setTextureOffset(13, 24).addBox(-8.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(1.0F, 17.5F, 7.0F);
        leg2.setTextureOffset(4, 24).addBox(0.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(5.0F, 17.5F, 0.0F);
        leg3.setTextureOffset(13, 24).addBox(-8.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(1.0F, 17.5F, 0.0F);
        leg4.setTextureOffset(4, 24).addBox(0.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(4.0F, 13.0F, 10.0F);


        tail_rotation = new ModelRenderer(this);
        tail_rotation.setRotationPoint(-4.0F, 2.5F, 1.5F);
        tail.addChild(tail_rotation);
        setRotationAngle(tail_rotation, 1.5708F, 0.0F, 0.0F);
        tail_rotation.setTextureOffset(30, 0).addBox(-1.0F, -3.5F, -2.5F, 2.0F, 7.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
