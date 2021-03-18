package net.minecraft.client.gui.social;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.Collection;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SocialInteractionsScreen extends Screen {
   protected static final ResourceLocation field_244666_a = new ResourceLocation("textures/gui/social_interactions.png");
   private static final ITextComponent field_244667_b = new TranslationTextComponent("gui.socialInteractions.tab_all");
   private static final ITextComponent field_244668_c = new TranslationTextComponent("gui.socialInteractions.tab_hidden");
   private static final ITextComponent field_244762_p = new TranslationTextComponent("gui.socialInteractions.tab_blocked");
   private static final ITextComponent field_244669_p = field_244667_b.func_230531_f_().func_240699_a_(TextFormatting.UNDERLINE);
   private static final ITextComponent field_244670_q = field_244668_c.func_230531_f_().func_240699_a_(TextFormatting.UNDERLINE);
   private static final ITextComponent field_244763_s = field_244762_p.func_230531_f_().func_240699_a_(TextFormatting.UNDERLINE);
   private static final ITextComponent field_244671_r = (new TranslationTextComponent("gui.socialInteractions.search_hint")).func_240699_a_(TextFormatting.ITALIC).func_240699_a_(TextFormatting.GRAY);
   private static final ITextComponent field_244764_u = (new TranslationTextComponent("gui.socialInteractions.search_empty")).func_240699_a_(TextFormatting.GRAY);
   private static final ITextComponent field_244672_s = (new TranslationTextComponent("gui.socialInteractions.empty_hidden")).func_240699_a_(TextFormatting.GRAY);
   private static final ITextComponent field_244765_w = (new TranslationTextComponent("gui.socialInteractions.empty_blocked")).func_240699_a_(TextFormatting.GRAY);
   private static final ITextComponent field_244766_x = new TranslationTextComponent("gui.socialInteractions.blocking_hint");
   private FilterList field_244673_t;
   private TextFieldWidget field_244674_u;
   private String field_244675_v = "";
   private SocialInteractionsScreen.Mode field_244676_w = SocialInteractionsScreen.Mode.ALL;
   private Button field_244677_x;
   private Button field_244678_y;
   private Button field_244760_E;
   private Button field_244761_F;
   @Nullable
   private ITextComponent field_244679_z;
   private int field_244662_A;
   private boolean field_244664_C;
   @Nullable
   private Runnable field_244665_D;

   public SocialInteractionsScreen() {
      super(new TranslationTextComponent("gui.socialInteractions.title"));
      this.func_244680_a(Minecraft.getInstance());
   }

   private int func_244689_k() {
      return Math.max(52, this.field_230709_l_ - 128 - 16);
   }

   private int func_244690_l() {
      return this.func_244689_k() / 16;
   }

   private int func_244691_m() {
      return 80 + this.func_244690_l() * 16 - 8;
   }

   private int func_244692_n() {
      return (this.field_230708_k_ - 238) / 2;
   }

   public String func_231167_h_() {
      return super.func_231167_h_() + ". " + this.field_244679_z.getString();
   }

   public void func_231023_e_() {
      super.func_231023_e_();
      this.field_244674_u.tick();
   }

   protected void func_231160_c_() {
      this.field_230706_i_.keyboardListener.enableRepeatEvents(true);
      if (this.field_244664_C) {
         this.field_244673_t.func_230940_a_(this.field_230708_k_, this.field_230709_l_, 88, this.func_244691_m());
      } else {
         this.field_244673_t = new FilterList(this, this.field_230706_i_, this.field_230708_k_, this.field_230709_l_, 88, this.func_244691_m(), 36);
      }

      int i = this.field_244673_t.func_230949_c_() / 3;
      int j = this.field_244673_t.func_230968_n_();
      int k = this.field_244673_t.func_244736_r();
      int l = this.field_230712_o_.func_238414_a_(field_244766_x) + 40;
      int i1 = 64 + 16 * this.func_244690_l();
      int j1 = (this.field_230708_k_ - l) / 2;
      this.field_244677_x = this.func_230480_a_(new Button(j, 45, i, 20, field_244667_b, (p_244686_1_) -> {
         this.func_244682_a(SocialInteractionsScreen.Mode.ALL);
      }));
      this.field_244678_y = this.func_230480_a_(new Button((j + k - i) / 2 + 1, 45, i, 20, field_244668_c, (p_244681_1_) -> {
         this.func_244682_a(SocialInteractionsScreen.Mode.HIDDEN);
      }));
      this.field_244760_E = this.func_230480_a_(new Button(k - i + 1, 45, i, 20, field_244762_p, (p_244769_1_) -> {
         this.func_244682_a(SocialInteractionsScreen.Mode.BLOCKED);
      }));
      this.field_244761_F = this.func_230480_a_(new Button(j1, i1, l, 20, field_244766_x, (p_244767_1_) -> {
         this.field_230706_i_.displayGuiScreen(new ConfirmOpenLinkScreen((p_244771_1_) -> {
            if (p_244771_1_) {
               Util.getOSType().openURI("https://aka.ms/javablocking");
            }

            this.field_230706_i_.displayGuiScreen(this);
         }, "https://aka.ms/javablocking", true));
      }));
      String s = this.field_244674_u != null ? this.field_244674_u.getText() : "";
      this.field_244674_u = new TextFieldWidget(this.field_230712_o_, this.func_244692_n() + 28, 78, 196, 16, field_244671_r) {
         protected IFormattableTextComponent func_230442_c_() {
            return !SocialInteractionsScreen.this.field_244674_u.getText().isEmpty() && SocialInteractionsScreen.this.field_244673_t.func_244660_f() ? super.func_230442_c_().func_240702_b_(", ").func_230529_a_(SocialInteractionsScreen.field_244764_u) : super.func_230442_c_();
         }
      };
      this.field_244674_u.setMaxStringLength(16);
      this.field_244674_u.setEnableBackgroundDrawing(false);
      this.field_244674_u.setVisible(true);
      this.field_244674_u.setTextColor(16777215);
      this.field_244674_u.setText(s);
      this.field_244674_u.setResponder(this::func_244687_b);
      this.field_230705_e_.add(this.field_244674_u);
      this.field_230705_e_.add(this.field_244673_t);
      this.field_244664_C = true;
      this.func_244682_a(this.field_244676_w);
   }

   private void func_244682_a(SocialInteractionsScreen.Mode p_244682_1_) {
      this.field_244676_w = p_244682_1_;
      this.field_244677_x.func_238482_a_(field_244667_b);
      this.field_244678_y.func_238482_a_(field_244668_c);
      this.field_244760_E.func_238482_a_(field_244762_p);
      Collection<UUID> collection;
      switch(p_244682_1_) {
      case ALL:
         this.field_244677_x.func_238482_a_(field_244669_p);
         collection = this.field_230706_i_.player.connection.func_244695_f();
         break;
      case HIDDEN:
         this.field_244678_y.func_238482_a_(field_244670_q);
         collection = this.field_230706_i_.func_244599_aA().func_244644_a();
         break;
      case BLOCKED:
         this.field_244760_E.func_238482_a_(field_244763_s);
         FilterManager filtermanager = this.field_230706_i_.func_244599_aA();
         collection = this.field_230706_i_.player.connection.func_244695_f().stream().filter(filtermanager::func_244757_e).collect(Collectors.toSet());
         break;
      default:
         collection = ImmutableList.of();
      }

      this.field_244676_w = p_244682_1_;
      this.field_244673_t.func_244759_a(collection, this.field_244673_t.func_230966_l_());
      if (!this.field_244674_u.getText().isEmpty() && this.field_244673_t.func_244660_f() && !this.field_244674_u.func_230999_j_()) {
         NarratorChatListener.INSTANCE.say(field_244764_u.getString());
      } else if (collection.isEmpty()) {
         if (p_244682_1_ == SocialInteractionsScreen.Mode.HIDDEN) {
            NarratorChatListener.INSTANCE.say(field_244672_s.getString());
         } else if (p_244682_1_ == SocialInteractionsScreen.Mode.BLOCKED) {
            NarratorChatListener.INSTANCE.say(field_244765_w.getString());
         }
      }

   }

   public void func_231164_f_() {
      this.field_230706_i_.keyboardListener.enableRepeatEvents(false);
   }

   public void func_230446_a_(MatrixStack p_230446_1_) {
      int i = this.func_244692_n() + 3;
      super.func_230446_a_(p_230446_1_);
      this.field_230706_i_.getTextureManager().bindTexture(field_244666_a);
      this.func_238474_b_(p_230446_1_, i, 64, 1, 1, 236, 8);
      int j = this.func_244690_l();

      for(int k = 0; k < j; ++k) {
         this.func_238474_b_(p_230446_1_, i, 72 + 16 * k, 1, 10, 236, 16);
      }

      this.func_238474_b_(p_230446_1_, i, 72 + 16 * j, 1, 27, 236, 8);
      this.func_238474_b_(p_230446_1_, i + 10, 76, 243, 1, 12, 12);
   }

   public void func_230430_a_(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
      this.func_244680_a(this.field_230706_i_);
      this.func_230446_a_(p_230430_1_);
      if (this.field_244679_z != null) {
         func_238475_b_(p_230430_1_, this.field_230706_i_.fontRenderer, this.field_244679_z, this.func_244692_n() + 8, 35, -1);
      }

      if (!this.field_244673_t.func_244660_f()) {
         this.field_244673_t.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
      } else if (!this.field_244674_u.getText().isEmpty()) {
         func_238472_a_(p_230430_1_, this.field_230706_i_.fontRenderer, field_244764_u, this.field_230708_k_ / 2, (78 + this.func_244691_m()) / 2, -1);
      } else {
         switch(this.field_244676_w) {
         case HIDDEN:
            func_238472_a_(p_230430_1_, this.field_230706_i_.fontRenderer, field_244672_s, this.field_230708_k_ / 2, (78 + this.func_244691_m()) / 2, -1);
            break;
         case BLOCKED:
            func_238472_a_(p_230430_1_, this.field_230706_i_.fontRenderer, field_244765_w, this.field_230708_k_ / 2, (78 + this.func_244691_m()) / 2, -1);
         }
      }

      if (!this.field_244674_u.func_230999_j_() && this.field_244674_u.getText().isEmpty()) {
         func_238475_b_(p_230430_1_, this.field_230706_i_.fontRenderer, field_244671_r, this.field_244674_u.field_230690_l_, this.field_244674_u.field_230691_m_, -1);
      } else {
         this.field_244674_u.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
      }

      this.field_244761_F.field_230694_p_ = this.field_244676_w == SocialInteractionsScreen.Mode.BLOCKED;
      super.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
      if (this.field_244665_D != null) {
         this.field_244665_D.run();
      }

   }

   public boolean func_231044_a_(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
      if (this.field_244674_u.func_230999_j_()) {
         this.field_244674_u.func_231044_a_(p_231044_1_, p_231044_3_, p_231044_5_);
      }

      return super.func_231044_a_(p_231044_1_, p_231044_3_, p_231044_5_) || this.field_244673_t.func_231044_a_(p_231044_1_, p_231044_3_, p_231044_5_);
   }

   public boolean func_231046_a_(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
      if (!this.field_244674_u.func_230999_j_() && this.field_230706_i_.gameSettings.field_244602_au.matchesKey(p_231046_1_, p_231046_2_)) {
         this.field_230706_i_.displayGuiScreen((Screen)null);
         return true;
      } else {
         return super.func_231046_a_(p_231046_1_, p_231046_2_, p_231046_3_);
      }
   }

   public boolean func_231177_au__() {
      return false;
   }

   private void func_244687_b(String p_244687_1_) {
      p_244687_1_ = p_244687_1_.toLowerCase(Locale.ROOT);
      if (!p_244687_1_.equals(this.field_244675_v)) {
         this.field_244673_t.func_244658_a(p_244687_1_);
         this.field_244675_v = p_244687_1_;
         this.func_244682_a(this.field_244676_w);
      }

   }

   private void func_244680_a(Minecraft p_244680_1_) {
      int i = p_244680_1_.getConnection().getPlayerInfoMap().size();
      if (this.field_244662_A != i) {
         String s = "";
         ServerData serverdata = p_244680_1_.getCurrentServerData();
         if (p_244680_1_.isIntegratedServerRunning()) {
            s = p_244680_1_.getIntegratedServer().getMOTD();
         } else if (serverdata != null) {
            s = serverdata.serverName;
         }

         if (i > 1) {
            this.field_244679_z = new TranslationTextComponent("gui.socialInteractions.server_label.multiple", s, i);
         } else {
            this.field_244679_z = new TranslationTextComponent("gui.socialInteractions.server_label.single", s, i);
         }

         this.field_244662_A = i;
      }

   }

   public void func_244683_a(NetworkPlayerInfo p_244683_1_) {
      this.field_244673_t.func_244657_a(p_244683_1_, this.field_244676_w);
   }

   public void func_244685_a(UUID p_244685_1_) {
      this.field_244673_t.func_244659_a(p_244685_1_);
   }

   public void func_244684_a(@Nullable Runnable p_244684_1_) {
      this.field_244665_D = p_244684_1_;
   }

   @OnlyIn(Dist.CLIENT)
   public static enum Mode {
      ALL,
      HIDDEN,
      BLOCKED;
   }
}
