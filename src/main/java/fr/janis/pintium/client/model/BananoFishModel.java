package fr.janis.pintium.client.model;
// Made with Blockbench 3.8.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.janis.pintium.entities.BananoFishEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BananoFishModel<T extends BananoFishEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer fin_top;
    private final ModelRenderer body_sub_1;
    private final ModelRenderer fin_right2;
    private final ModelRenderer fin_left2;
    private final ModelRenderer fin_back;
    private final ModelRenderer head;
    private final ModelRenderer nose;
    private final ModelRenderer fin_left;
    private final ModelRenderer fin_right;
    private final ModelRenderer tail;
    private final ModelRenderer body_banana;
    private final ModelRenderer cou;
    private final ModelRenderer cou2;
    private final ModelRenderer cou3;

    public BananoFishModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 22.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

        fin_top = new ModelRenderer(this);
        fin_top.setRotationPoint(0.0F, -2.0F, 5.0F);
        body.addChild(fin_top);
        setRotationAngle(fin_top, 0.0F, -1.5708F, 0.0F);


        body_sub_1 = new ModelRenderer(this);
        body_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        fin_top.addChild(body_sub_1);
        body_sub_1.setTextureOffset(20, 0).addBox(-5.0F, 0.0F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);

        fin_right2 = new ModelRenderer(this);
        fin_right2.setRotationPoint(1.0F, 1.0F, 0.0F);
        body.addChild(fin_right2);
        setRotationAngle(fin_right2, 0.0F, 0.0F, 0.7854F);
        fin_right2.setTextureOffset(24, 4).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        fin_left2 = new ModelRenderer(this);
        fin_left2.setRotationPoint(-1.0F, 1.0F, 0.0F);
        body.addChild(fin_left2);
        setRotationAngle(fin_left2, 0.0F, 0.0F, -0.7854F);
        fin_left2.setTextureOffset(24, 1).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        fin_back = new ModelRenderer(this);
        fin_back.setRotationPoint(0.0F, 20.0F, 0.0F);


        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 22.0F, 0.0F);
        head.setTextureOffset(11, 0).addBox(-1.0F, -5.0F, -9.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

        nose = new ModelRenderer(this);
        nose.setRotationPoint(0.0F, 22.0F, -3.0F);
        nose.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, -7.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        fin_left = new ModelRenderer(this);
        fin_left.setRotationPoint(0.0F, 24.0F, 0.0F);


        fin_right = new ModelRenderer(this);
        fin_right.setRotationPoint(0.0F, 24.0F, 0.0F);


        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 22.0F, 7.0F);
        tail.setTextureOffset(20, 1).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, false);

        body_banana = new ModelRenderer(this);
        body_banana.setRotationPoint(-0.5F, 21.5F, -2.5F);
        setRotationAngle(body_banana, -0.5672F, 0.0F, 0.0F);
        body_banana.setTextureOffset(0, 0).addBox(0.0F, -1.5F, -5.5F, 1.0F, 2.0F, 9.0F, 0.0F, false);

        cou = new ModelRenderer(this);
        cou.setRotationPoint(0.0F, 25.0F, -2.0F);
        setRotationAngle(cou, -0.3054F, 0.0F, 0.0F);
        cou.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, -4.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        cou.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        cou2 = new ModelRenderer(this);
        cou2.setRotationPoint(1.0F, 19.5F, -4.0F);
        setRotationAngle(cou2, -0.6981F, -1.5708F, 0.5236F);
        cou2.setTextureOffset(0, 0).addBox(0.0F, -1.5F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        cou3 = new ModelRenderer(this);
        cou3.setRotationPoint(-1.0F, 19.0F, -4.5F);
        setRotationAngle(cou3, -0.1745F, 1.4399F, -0.3054F);
        cou3.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_back.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        nose.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_left.render(matrixStack, buffer, packedLight, packedOverlay);
        fin_right.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        body_banana.render(matrixStack, buffer, packedLight, packedOverlay);
        cou.render(matrixStack, buffer, packedLight, packedOverlay);
        cou2.render(matrixStack, buffer, packedLight, packedOverlay);
        cou3.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}