package fr.janis.pintium.client.model;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.janis.pintium.entities.BananosaurEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.MathHelper;

public class BananosaurModel<T extends BananosaurEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer rotation;
    private final ModelRenderer head;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer body2;
    private final ModelRenderer tail;
    private final ModelRenderer strange_thing_of_banana1;
    private final ModelRenderer strange_thing_of_banana2;
    private final ModelRenderer strange_thing_of_banana3;

    public BananosaurModel() {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 5.0F, 2.0F);


        rotation = new ModelRenderer(this);
        rotation.setRotationPoint(0.0F, -3.0F, -3.0F);
        body.addChild(rotation);
        setRotationAngle(rotation, 0.9163F, 0.0F, 0.0F);
        rotation.setTextureOffset(18, 4).addBox(-2.0F, -12.0F, -10.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 4.0F, -8.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -13.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(4.0F, 12.0F, 7.0F);
        leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
        leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(4.0F, 12.0F, -6.0F);
        leg3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(-4.0F, 12.0F, -6.0F);
        leg4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        body2 = new ModelRenderer(this);
        body2.setRotationPoint(0.0F, 24.0F, 0.0F);
        body2.setTextureOffset(0, 0).addBox(-3.0F, -14.0F, -4.0F, 7.0F, 4.0F, 15.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-0.5F, 12.5F, 11.5F);
        setRotationAngle(tail, 0.6545F, 0.0F, 0.0F);
        tail.setTextureOffset(0, 0).addBox(-2.5F, -1.5F, -0.5F, 7.0F, 3.0F, 18.0F, 0.0F, false);
        tail.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 16.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
        tail.setTextureOffset(0, 0).addBox(-2.0F, 1.0F, 16.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
        tail.setTextureOffset(0, 0).addBox(4.0F, -2.0F, 16.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        tail.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 16.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

        strange_thing_of_banana1 = new ModelRenderer(this);
        strange_thing_of_banana1.setRotationPoint(0.0F, 25.0F, -11.0F);
        setRotationAngle(strange_thing_of_banana1, -0.48F, 0.0F, 0.0F);
        strange_thing_of_banana1.setTextureOffset(0, 0).addBox(-2.0F, -26.0F, -9.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);

        strange_thing_of_banana2 = new ModelRenderer(this);
        strange_thing_of_banana2.setRotationPoint(4.0F, 1.0F, -10.0F);
        setRotationAngle(strange_thing_of_banana2, 0.0F, 0.0F, 0.829F);
        strange_thing_of_banana2.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -5.0F, 1.0F, 4.0F, 5.0F, 0.0F, false);

        strange_thing_of_banana3 = new ModelRenderer(this);
        strange_thing_of_banana3.setRotationPoint(-3.5F, 0.0F, -12.0F);
        setRotationAngle(strange_thing_of_banana3, 0.0F, 0.0F, -0.829F);
        strange_thing_of_banana3.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
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
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        body2.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        strange_thing_of_banana1.render(matrixStack, buffer, packedLight, packedOverlay);
        strange_thing_of_banana2.render(matrixStack, buffer, packedLight, packedOverlay);
        strange_thing_of_banana3.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}