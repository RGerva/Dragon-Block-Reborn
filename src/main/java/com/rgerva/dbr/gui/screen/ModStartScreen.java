package com.rgerva.dbr.gui.screen;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.ModStats;
import com.rgerva.dbr.network.ModMessages;
import com.rgerva.dbr.network.packages.UpgradeAttributePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModStartScreen extends Screen {
    private final ModStats.AttributeModifiers stats;
    private static final int MAX_STAT_VALUE = 100;

    private final Map<String, Button> upgradeButtons = new HashMap<>();

    public ModStartScreen(ModStats.AttributeModifiers stats) {
        super(Component.literal("Player Stats"));
        this.stats = stats;
    }

    @Override
    protected void init() {
        int startX = this.width / 2 + 60;
        int startY = this.height / 4 + 20;

        String[] attrs = {"STR", "DEX", "CON", "WIL", "MND", "SPI"};

        for (int i = 0; i < attrs.length; i++) {
            int y = startY + i * 18;
            String attr = attrs[i];
            Button button = Button.builder(Component.literal("+"), btn -> {
                System.out.println("Upgrade em " + attr);
                ModMessages.sendToServer(new UpgradeAttributePacket(attr));
            }).pos(startX, y).size(20, 20).build();

            this.upgradeButtons.put(attr, button);
            this.addRenderableWidget(button);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        int x = this.width / 2 - 100;
        int y = this.height / 4;

        guiGraphics.drawCenteredString(this.font, Component.literal("Atributos do Jogador"), this.width / 2, y, 0xFFFFFF);
        y += 20;

        drawBar(guiGraphics, x, y, "STR", (int) stats.strPercent()); y += 18;
        drawBar(guiGraphics, x, y, "DEX", (int) stats.dexPercent()); y += 18;
        drawBar(guiGraphics, x, y, "CON", (int) stats.conPercent()); y += 18;
        drawBar(guiGraphics, x, y, "WIL", (int) stats.wilPercent()); y += 18;
        drawBar(guiGraphics, x, y, "MND", (int) stats.mndPercent()); y += 18;
        drawBar(guiGraphics, x, y, "SPI", (int) stats.spiPercent()); y += 18;

        DragonBlockReborn.LOGGER.debug("STR: " + stats.strPercent());

        guiGraphics.drawString(this.font, Component.literal("Habilidades: [em breve]"), x, y + 10, 0xAAAAFF);
    }

    private void drawBar(GuiGraphics guiGraphics, int x, int y, String label, int value) {
        Font font = Minecraft.getInstance().font;

        int barWidth = 100;
        int barHeight = 10;
        int filled = (int) ((value / (float) MAX_STAT_VALUE) * barWidth);

        guiGraphics.drawString(font, Component.literal(label + ": " + value), x, y, 0xFFFFFF);
        guiGraphics.fill(x + 60, y + 1, x + 60 + barWidth, y + 1 + barHeight, 0xFF333333);
        guiGraphics.fill(x + 60, y + 1, x + 60 + filled, y + 1 + barHeight, 0xFF00FF00);
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}


