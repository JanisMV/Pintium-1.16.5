package net.minecraft.client.gui;

import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.WithNarratorSettingsScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AccessibilityScreen extends WithNarratorSettingsScreen {
   private static final AbstractOption[] OPTIONS = new AbstractOption[]{AbstractOption.NARRATOR, AbstractOption.SHOW_SUBTITLES, AbstractOption.ACCESSIBILITY_TEXT_BACKGROUND_OPACITY, AbstractOption.ACCESSIBILITY_TEXT_BACKGROUND, AbstractOption.CHAT_OPACITY, AbstractOption.field_238235_g_, AbstractOption.field_238236_h_, AbstractOption.AUTO_JUMP, AbstractOption.SNEAK, AbstractOption.SPRINT, AbstractOption.field_243219_k, AbstractOption.field_243218_j};

   public AccessibilityScreen(Screen p_i51123_1_, GameSettings p_i51123_2_) {
      super(p_i51123_1_, p_i51123_2_, new TranslationTextComponent("options.accessibility.title"), OPTIONS);
   }

   protected void func_244718_c() {
      this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 155, this.field_230709_l_ - 27, 150, 20, new TranslationTextComponent("options.accessibility.link"), (p_244738_1_) -> {
         this.field_230706_i_.displayGuiScreen(new ConfirmOpenLinkScreen((p_244739_1_) -> {
            if (p_244739_1_) {
               Util.getOSType().openURI("https://aka.ms/MinecraftJavaAccessibility");
            }

            this.field_230706_i_.displayGuiScreen(this);
         }, "https://aka.ms/MinecraftJavaAccessibility", true));
      }));
      this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 5, this.field_230709_l_ - 27, 150, 20, DialogTexts.field_240632_c_, (p_244737_1_) -> {
         this.field_230706_i_.displayGuiScreen(this.parentScreen);
      }));
   }
}
