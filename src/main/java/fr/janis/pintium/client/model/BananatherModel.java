package fr.janis.pintium.client.model;
// Made with Blockbench 3.8.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.janis.pintium.entities.BananatherEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BananatherModel<T extends BananatherEntity> extends EntityModel<T> {
    private final ModelRenderer body1;
    private final ModelRenderer body2;
    private final ModelRenderer body3;
    private final ModelRenderer body4;
    private final ModelRenderer body5;
    private final ModelRenderer head1;
    private final ModelRenderer head2;
    private final ModelRenderer head3;

    public BananatherModel() {
        textureWidth = 64;
        textureHeight = 64;

        body1 = new ModelRenderer(this);
        body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1.setTextureOffset(0, 16).addBox(-10.0F, 3.9F, -0.5F, 20.0F, 3.0F, 3.0F, 0.0F, false);

        body2 = new ModelRenderer(this);
        body2.setRotationPoint(3.0F, 6.9F, -0.5F);
        body2.setTextureOffset(0, 22).addBox(-5.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);
        body2.setTextureOffset(24, 22).addBox(-9.0F, 4.0F, 0.5F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        body2.setTextureOffset(24, 22).addBox(-9.0F, 6.0F, 0.5F, 11.0F, 2.0F, 2.0F, 0.0F, false);

        body3 = new ModelRenderer(this);
        body3.setRotationPoint(3.0F, 16.9F, -0.5F);
        body3.setTextureOffset(12, 22).addBox(-5.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        body4 = new ModelRenderer(this);
        body4.setRotationPoint(9.5F, 10.4F, 1.0F);
        setRotationAngle(body4, 0.0F, 0.0F, -0.3054F);
        body4.setTextureOffset(24, 22).addBox(-5.5F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        body4.setTextureOffset(24, 22).addBox(-5.5F, 1.0F, -1.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);

        body5 = new ModelRenderer(this);
        body5.setRotationPoint(-9.5F, 10.4F, 1.0F);
        setRotationAngle(body5, 0.0F, 0.0F, 0.3491F);
        body5.setTextureOffset(24, 22).addBox(-5.5F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        body5.setTextureOffset(24, 22).addBox(-5.5F, 1.0F, -1.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);

        head1 = new ModelRenderer(this);
        head1.setRotationPoint(1.0F, 0.0F, 0.0F);
        head1.setTextureOffset(0, 0).addBox(-5.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        head2 = new ModelRenderer(this);
        head2.setRotationPoint(9.0F, 4.0F, -1.0F);
        head2.setTextureOffset(32, 0).addBox(-21.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

        head3 = new ModelRenderer(this);
        head3.setRotationPoint(-9.0F, 4.0F, -1.0F);
        head3.setTextureOffset(32, 0).addBox(15.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = MathHelper.cos(ageInTicks * 0.1F);
        this.body2.rotateAngleX = (0.065F + 0.05F * f) * (float)Math.PI;
        this.body4.rotateAngleX = (0.065F + 0.05F * f) * (float)Math.PI;
        this.body5.rotateAngleX = (0.065F + 0.05F * f) * (float)Math.PI;
        //this.body2.setRotationPoint(-2.0F, 6.9F + MathHelper.cos(this.body2.rotateAngleX) * 10.0F, -0.5F + MathHelper.sin(this.body2.rotateAngleX) * 10.0F);
        this.body3.rotateAngleX = (0.265F + 0.1F * f) * (float)Math.PI;
        this.head1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head1.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body1.render(matrixStack, buffer, packedLight, packedOverlay);
        body2.render(matrixStack, buffer, packedLight, packedOverlay);
        body3.render(matrixStack, buffer, packedLight, packedOverlay);
        body4.render(matrixStack, buffer, packedLight, packedOverlay);
        body5.render(matrixStack, buffer, packedLight, packedOverlay);
        head1.render(matrixStack, buffer, packedLight, packedOverlay);
        head2.render(matrixStack, buffer, packedLight, packedOverlay);
        head3.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}