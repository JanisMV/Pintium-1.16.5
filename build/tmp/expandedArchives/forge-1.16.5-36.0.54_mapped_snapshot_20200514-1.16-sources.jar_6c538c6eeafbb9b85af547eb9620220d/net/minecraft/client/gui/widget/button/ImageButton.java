package net.minecraft.client.gui.widget.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ImageButton extends Button {
   private final ResourceLocation resourceLocation;
   private final int xTexStart;
   private final int yTexStart;
   private final int yDiffText;
   private final int textureWidth;
   private final int textureHeight;

   public ImageButton(int xIn, int yIn, int widthIn, int heightIn, int xTexStartIn, int yTexStartIn, int yDiffTextIn, ResourceLocation resourceLocationIn, Button.IPressable onPressIn) {
      this(xIn, yIn, widthIn, heightIn, xTexStartIn, yTexStartIn, yDiffTextIn, resourceLocationIn, 256, 256, onPressIn);
   }

   public ImageButton(int xIn, int yIn, int widthIn, int heightIn, int xTexStartIn, int yTexStartIn, int yDiffTextIn, ResourceLocation resourceLocationIn, int p_i51135_9_, int p_i51135_10_, Button.IPressable onPressIn) {
      this(xIn, yIn, widthIn, heightIn, xTexStartIn, yTexStartIn, yDiffTextIn, resourceLocationIn, p_i51135_9_, p_i51135_10_, onPressIn, StringTextComponent.field_240750_d_);
   }

   public ImageButton(int p_i232261_1_, int p_i232261_2_, int p_i232261_3_, int p_i232261_4_, int p_i232261_5_, int p_i232261_6_, int p_i232261_7_, ResourceLocation p_i232261_8_, int p_i232261_9_, int p_i232261_10_, Button.IPressable p_i232261_11_, ITextComponent p_i232261_12_) {
      this(p_i232261_1_, p_i232261_2_, p_i232261_3_, p_i232261_4_, p_i232261_5_, p_i232261_6_, p_i232261_7_, p_i232261_8_, p_i232261_9_, p_i232261_10_, p_i232261_11_, field_238486_s_, p_i232261_12_);
   }

   public ImageButton(int p_i244513_1_, int p_i244513_2_, int p_i244513_3_, int p_i244513_4_, int p_i244513_5_, int p_i244513_6_, int p_i244513_7_, ResourceLocation p_i244513_8_, int p_i244513_9_, int p_i244513_10_, Button.IPressable p_i244513_11_, Button.ITooltip p_i244513_12_, ITextComponent p_i244513_13_) {
      super(p_i244513_1_, p_i244513_2_, p_i244513_3_, p_i244513_4_, p_i244513_13_, p_i244513_11_, p_i244513_12_);
      this.textureWidth = p_i244513_9_;
      this.textureHeight = p_i244513_10_;
      this.xTexStart = p_i244513_5_;
      this.yTexStart = p_i244513_6_;
      this.yDiffText = p_i244513_7_;
      this.resourceLocation = p_i244513_8_;
   }

   public void setPosition(int xIn, int yIn) {
      this.field_230690_l_ = xIn;
      this.field_230691_m_ = yIn;
   }

   public void func_230431_b_(MatrixStack p_230431_1_, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
      Minecraft minecraft = Minecraft.getInstance();
      minecraft.getTextureManager().bindTexture(this.resourceLocation);
      int i = this.yTexStart;
      if (this.func_230449_g_()) {
         i += this.yDiffText;
      }

      RenderSystem.enableDepthTest();
      func_238463_a_(p_230431_1_, this.field_230690_l_, this.field_230691_m_, (float)this.xTexStart, (float)i, this.field_230688_j_, this.field_230689_k_, this.textureWidth, this.textureHeight);
      if (this.func_230449_g_()) {
         this.func_230443_a_(p_230431_1_, p_230431_2_, p_230431_3_);
      }

   }
}
