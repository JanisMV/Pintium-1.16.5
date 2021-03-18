package fr.janis.pintium.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.janis.pintium.data.CapabilityEntityKilled;
import fr.janis.pintium.init.PintiumEntities;
import fr.janis.pintium.main;
import fr.janis.pintium.network.Network;
import fr.janis.pintium.network.packet.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class TameMobs extends Screen {
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(main.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final ClientPlayerEntity player;
    private final World world;

    private int guiLeft;
    private int guiTop;

    private String dead_Entity_name;

    public TameMobs() {
        super(new TranslationTextComponent("pintium.tamemobs.title"));
        this.player = Minecraft.getInstance().player;
        this.world = Minecraft.getInstance().player.world;
    }

    //init Gui
    protected void init() {

        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        player.getCapability(CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY).ifPresent(h -> {
            this.dead_Entity_name = h.getName();
        });

        main.LOGGER.debug(this.dead_Entity_name);
        main.LOGGER.debug(PintiumEntities.RATEL.get().getName().getString());

        if (this.dead_Entity_name.equals(PintiumEntities.RATEL.get().getName().getString()))
        {
            this.addButton(new Button(guiLeft  + (xSize/2) - 70, guiTop + (ySize/2) - 10, 150, 20, new TranslationTextComponent("pintium.tamemobs.button.ratel.title"), button -> {
                Network.CHANNEL.sendToServer(new TameRatelPacket());
            }));
        }
    }

    @Override   
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        drawBackGround(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    private void drawBackGround(MatrixStack matrixStack) {
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE_LOCATION);
        this.blit(matrixStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
