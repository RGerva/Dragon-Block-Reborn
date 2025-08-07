/**
 * Generic Class: ModUIComponents <T> A generic structure that works with type parameters.
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

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

public class ModUIComponents {
  public static Button createButton(
      int x, int y, int width, int height, String text, Button.OnPress onPress) {

    return Button.builder(Component.literal(text), onPress).bounds(x, y, width, height).build();
  }

  public static EditBox createReadOnlyTextBox(
      Font font, int x, int y, int width, int height, String txt) {

    EditBox box = new EditBox(font, x, y, width, height, Component.literal(txt));
    box.setValue(txt);
    box.setEditable(false);
    box.setFocused(false);
    box.setBordered(true);
    box.setCentered(true);
    return box;
  }
}
