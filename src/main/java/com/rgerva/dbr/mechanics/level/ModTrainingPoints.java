/**
 * Generic Class: ModTrainingPoints <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics.level;

import com.rgerva.dbr.mechanics.types.ModTypes;
import net.minecraft.world.entity.player.Player;

public class ModTrainingPoints {
	public static int getMaxDailyTP(Player player) {
		return 20 * player.experienceLevel;
	}

	public static int getTPFromMiniGame(Player player) {
		if (getMaxDailyTP(player) > 0) {
			// Consome 1 TP para jogar
			return 1;
		}
		return 0;
	}

	public static int getTPFromCombat(int mind, double powerRelease) {
		int mindFactor = mind / 5;
		return 2 + (2 * mindFactor * (int)(powerRelease / 100));
	}

	public static int getTPFromKiAttack(KiAttackType type) {
			return switch (type) {
					case BARRAGE -> 1;
					case WAVE, BALL, DISK, LASER, SPIRAL -> 2;
					case LARGE_BALL, EXPLOSION -> 3;
					default -> 0;
			};
	}

	public static double getTPGainRateModifier(int arcosianFormLevel, ModLevel.ModDifficulty difficulty, int dexterity, double weight, ModTypes.RaceType race) {
		double modifier = 1.0;

		// Penalidade por forma Arcosian
		modifier -= 0.04 * arcosianFormLevel;

		// Bônus de dificuldade
		modifier += difficulty.getModifier();

		// Equação de Destreza e Peso
		double base = dexterity / 16.0;
		if (base != 0) {
			modifier += (weight - base) / base;
		}

		// Bônus por raça
		if (race == ModTypes.RaceType.HUMAN || race == ModTypes.RaceType.NAMEKIAN) {
			modifier += 0.05;
		}

		// Limite máximo de 50% de aumento
		return Math.min(modifier, 1.5);
	}


	public enum KiAttackType {
		BARRAGE, WAVE, BALL, DISK, LASER, SPIRAL, LARGE_BALL, EXPLOSION
	}

}
