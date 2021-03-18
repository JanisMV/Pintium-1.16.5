package fr.janis.pintium.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.janis.pintium.main;
import fr.janis.pintium.network.Network;
import fr.janis.pintium.network.packet.LaunchFireBall;
import fr.janis.pintium.network.packet.SpawnABoatPacket;
import fr.janis.pintium.network.packet.SpawnSomeZombiesPacket;
import fr.janis.pintium.network.packet.TransformToABlockPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SpellsGui extends Screen {
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(main.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final ClientPlayerEntity player;
    private final World world;

    private int guiLeft;
    private int guiTop;

    public SpellsGui() {
        super(new TranslationTextComponent("pintium.guispells.title"));
        this.player = Minecraft.getInstance().player;
        this.world = Minecraft.getInstance().player.world;
    }

    //init Gui
    protected void init() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.addButton(new Button(guiLeft  + (xSize/2) - 70, guiTop + (ySize/2) - 10, 150, 20, new TranslationTextComponent("pintium.guispells.button.navis.title"), button -> {
            Network.CHANNEL.sendToServer(new SpawnABoatPacket());
        }));
        this.addButton(new Button(guiLeft + (xSize/2) - 70, guiTop, 150, 20, new TranslationTextComponent("pintium.guispells.button.inertium.title"), button -> {
            Network.CHANNEL.sendToServer(new TransformToABlockPacket());
        }));
        this.addButton(new Button(guiLeft + (xSize/2) - 70, guiTop + 123, 150, 20, new TranslationTextComponent("pintium.guispells.button.zombium.title"), button -> {
            Network.CHANNEL.sendToServer(new SpawnSomeZombiesPacket());
        }));
        this.addButton(new Button(guiLeft + (xSize/2) - 70, guiTop + 30, 150, 20, new TranslationTextComponent("pintium.guispells.button.ignis.title"), button -> {
            Network.CHANNEL.sendToServer(new LaunchFireBall());
        }));
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
