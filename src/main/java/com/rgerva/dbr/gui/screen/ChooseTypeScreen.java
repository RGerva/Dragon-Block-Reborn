/**
 * Generic Class: ChooseTypeScreen <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.gui.screen;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.types.ModTypes;
import com.rgerva.dbr.network.interfaces.IModAttributesSync;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChooseTypeScreen extends Screen implements IModAttributesSync {
    private static final ModTypes.RaceType[] ALL_RACES = ModTypes.RaceType.values();
    private static final ModTypes.ClassType[] ALL_CLASS = ModTypes.ClassType.values();

    private int currentRaceIndex = 0;
    private int currentClassIndex = 0;
    private ModTypes.RaceType raceType;
    private ModTypes.ClassType classType;

    ModTypes.RaceClassKey key;
    ModAttributes.AttributeModifiers modifiers;

    Map<ModAttributes.Attributes, Float> visualAttributes = new HashMap<>();
    private final Map<String, EditBox> attributesTxtBox = new HashMap<>();

    Player player;

    public ChooseTypeScreen(Player player, ModTypes.RaceType raceType,
                            ModTypes.ClassType classType) {
        super(Component.literal("Choose your Class"));
        this.raceType = raceType;
        this.classType = classType;
        this.currentRaceIndex = Arrays.asList(ALL_RACES).indexOf(raceType);
        this.currentClassIndex = Arrays.asList(ALL_CLASS).indexOf(classType);
        this.player = player;
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2 - 100;

        raceBar(centerX, centerY);
        classBar(centerX, centerY + 25);

        updateAttributesDisplay();

        acceptedClass(centerX - 50, centerY + 100);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    protected void acceptedClass(int centerX, int centerY){
    Button btnAccept =
        ModUIComponents.createButton(
            centerX,
            centerY,
            100,
            20,
            "DONE",
            (btn) -> {
              updateAttributesDisplay();

              DragonBlockReborn.LOGGER.info("attributes {}", visualAttributes.values());

              syncToServer();
              Minecraft.getInstance().setScreen(null);
            });

        this.addRenderableWidget(btnAccept);
    }

    protected void updateAttributesDisplay() {
        this.attributesTxtBox.values().forEach(this::removeWidget);
        this.attributesTxtBox.clear();

        this.key = new ModTypes.RaceClassKey(raceType, classType);
        this.modifiers = ModAttributes.MODIFIERS.get(key);
        this.visualAttributes = ModAttributes.showAttributes(modifiers);

        int centerX = this.width / 2;
        int centerY = this.height / 2 - 100 + 75;
        showAttributes(centerX, centerY, visualAttributes);
    }


    protected void showAttributes(int centerX, int centerY,
                                  Map<ModAttributes.Attributes, Float> visualAttributes){
        int i = 0;
        for (Map.Entry<ModAttributes.Attributes, Float> entry : visualAttributes.entrySet()) {
            int y = centerY + i * 24;

            String txtAttr = entry.getKey().name() + ": " + entry.getValue();

            int boxWidth = this.font.width(txtAttr) + 20;
            int boxHeight = 20;
            int boxX = centerX - (boxWidth / 2);

            EditBox txtBox = ModUIComponents.createReadOnlyTextBox(
                    this.font,
                    boxX,
                    y,
                    boxWidth,
                    boxHeight,
                    txtAttr
            );

            this.attributesTxtBox.put(txtAttr, txtBox);
            this.addRenderableWidget(txtBox);
            i++;
        }

    }

    protected void classBar(int centerX, int centerY){
        int maxLen = Arrays.stream(ALL_CLASS)
                .map(ModTypes.ClassType::getFullName)
                .map(this.font::width)
                .max(Integer::compare)
                .orElse(100);

        int padding = 20;
        int height = 20;
        int width = height;

        EditBox txtBox = ModUIComponents.createReadOnlyTextBox(this.font,
                centerX - (maxLen + padding) / 2, centerY,
                maxLen + padding,
                height,
                classType.getFullName().getString());

        Button btnPlus = ModUIComponents.createButton(txtBox.getX() + txtBox.getWidth() + padding,
                txtBox.getY(),
                width, height,
                ">",
                (btn) -> {
                    currentClassIndex = (currentClassIndex + 1) % ALL_CLASS.length;
                    classType = ALL_CLASS[currentClassIndex];
                    txtBox.setValue(classType.getFullName().getString());
                    updateAttributesDisplay();
                });

        Button btnMinus = ModUIComponents.createButton(txtBox.getX() - padding - height,
                txtBox.getY(),
                width,
                height, "<",
                (btn) -> {
                    currentClassIndex = (currentClassIndex - 1 + ALL_CLASS.length) % ALL_CLASS.length;
                    classType = ALL_CLASS[currentClassIndex];
                    txtBox.setValue(classType.getFullName().getString());
                    updateAttributesDisplay();
                });

        this.addRenderableWidget(txtBox);
        this.addRenderableWidget(btnPlus);
        this.addRenderableWidget(btnMinus);
    }

    protected void raceBar(int centerX, int centerY){
        int maxLen = Arrays.stream(ALL_RACES)
                .map(ModTypes.RaceType::getFullName)
                .map(this.font::width)
                .max(Integer::compare)
                .orElse(100);

        int padding = 20;
        int height = 20;
        int width = height;

        EditBox txtBox = ModUIComponents.createReadOnlyTextBox(this.font,
                centerX - (maxLen + padding) / 2, centerY,
                maxLen + padding,
                height,
                raceType.getFullName().getString());

        Button btnPlus = ModUIComponents.createButton(txtBox.getX() + txtBox.getWidth() + padding,
                txtBox.getY(),
                width, height,
                ">",
                (btn) -> {
                    currentRaceIndex = (currentRaceIndex + 1) % ALL_RACES.length;
                    raceType = ALL_RACES[currentRaceIndex];
                    txtBox.setValue(raceType.getFullName().getString());
                    updateAttributesDisplay();
                });

        Button btnMinus = ModUIComponents.createButton(txtBox.getX() - padding - height,
                txtBox.getY(),
                width,
                height, "<",
                (btn) -> {
                    currentRaceIndex = (currentRaceIndex - 1 + ALL_RACES.length) % ALL_RACES.length;
                    raceType = ALL_RACES[currentRaceIndex];
                    txtBox.setValue(raceType.getFullName().getString());
                    updateAttributesDisplay();
                });

        this.addRenderableWidget(txtBox);
        this.addRenderableWidget(btnPlus);
        this.addRenderableWidget(btnMinus);
    }

    @Override
    public Map<ModAttributes.Attributes, Float> getInterfaceAttributes() {
        return visualAttributes;
    }
}
