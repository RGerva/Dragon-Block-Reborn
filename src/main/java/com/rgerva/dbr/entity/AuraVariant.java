/**
 * Enum: AuraVariant
 * Represents predefined constants for a specific purpose.
 * <p>
 * Created by: rgerv
 * On: 2025/ago.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum AuraVariant {
		AURA(0),
		AURA_MER(1),
		AURA_LOW(3);

		private static final AuraVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(AuraVariant::getId)).toArray(AuraVariant[]::new);

		private final int id;

		AuraVariant(int id) {
				this.id = id;
		}

		public int getId() {
				return id;
		}

		public static AuraVariant byId(int id) {
				return BY_ID[id % BY_ID.length];
		}
}
