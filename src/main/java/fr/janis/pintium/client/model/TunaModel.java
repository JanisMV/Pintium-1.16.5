package fr.janis.pintium.client.model;// Made with Blockbench 3.8.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.janis.pintium.entities.TunaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class TunaModel<T extends TunaEntity> extends EntityModel<T> {
    private final ModelRenderer body_front;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer body_back;
    private final ModelRenderer head;
    private final ModelRenderer fin_back_1;
    private final ModelRenderer fin_back_2;
    private final ModelRenderer tail;
    private final ModelRenderer fin_left;
    private final ModelRenderer fin_right;
    private final ModelRenderer dick;

    public TunaModel() {
        textureWidth = 32;
        textureHeight = 32;

        body_front = new ModelRenderer(this);
        body_front.setRotationPoint(0.0F, 18.0F, -4.0F);
        body_front.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-1.5F, 1.5F, 0.0F);
        body_front.addChild(bone);
        setRotationAngle(bone, -1.5708F, 0.0F, -0.7854F);
        bone.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(1.5F, 1.5F, 0.0F);
        body_front.addChild(bone2);
        setRotationAngle(bone2, -1.5708F, 0.0F, 0.7854F);
        bone2.setTextureOffset(4, 0).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        body_back = new ModelRenderer(this);
        body_back.setRotationPoint(0.0F, 18.0F, 4.0F);
        body_back.setTextureOffset(0, 13).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);

        dick = new ModelRenderer(this);
        dick.setRotationPoint(0.0F, 6.0F, -4.0F);
        body_back.addChild(dick);
        dick.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        dick.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        dick.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        dick.setTextureOffset(0, 0).addBox(1.0F, -4.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.0F, 8.0F);
        body_back.addChild(tail);
        tail.setTextureOffset(20, 10).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 18.0F, -4.0F);
        head.setTextureOffset(22, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

        fin_back_1 = new ModelRenderer(this);
        fin_back_1.setRotationPoint(0.0F, 13.5F, 1.0F);
        fin_back_1.setTextureOffset(4, 2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        fin_back_2 = new ModelRenderer(this);
        fin_back_2.setRotationPoint(0.0F, 13.5F, 3.0F);
        fin_back_2.setTextureOffset(2, 3).addBox(0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);

        fin_left = new ModelRenderer(this);
        fin_left.setRotationPoint(0.0F, 24.0F, 0.0F);


        fin_right = new ModelRenderer(this);
        fin_right.setRotationPoint(0.0F, 24.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        float f1 = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        this.body_back.rotateAngleY = -f * 0.25F * MathHelper.sin(f1 * 0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body_front.render(matrixStack, buffer, packedLight, packedOverlay);
        body_back.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_back_1.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_back_2.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_left.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_right.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}