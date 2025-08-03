package com.rgerva.dbr.mechanics;

import com.rgerva.dbr.mechanics.ModStats.*;

public class PlayerStatCapability implements IPlayerStatCapability {

    private ModAttributes attributes = new ModAttributes(10, 10, 10, 10, 10, 10);
    private RaceType race = RaceType.HUMAN;
    private ClassType clazz = ClassType.MARTIAL_ARTIST;
    private float powerRelease = 0f;
    private int trainingPoints = 0;
    private int tpSpentToday = 0;
    private int level = 1;

    public ModAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ModAttributes attributes) {
        this.attributes = attributes;
    }

    public RaceType getRace() {
        return race;
    }

    public void setRace(RaceType race) {
        this.race = race;
    }

    public ClassType getClazz() {
        return clazz;
    }

    public void setClazz(ClassType clazz) {
        this.clazz = clazz;
    }

    public float getPowerRelease() {
        return powerRelease;
    }

    public void setPowerRelease(float powerRelease) {
        this.powerRelease = powerRelease;
    }

    public int getTrainingPoints() {
        return trainingPoints;
    }

    public void addTrainingPoints(int amount) {
        trainingPoints += amount;
    }
    public void spendTrainingPoints(int amount) {
        trainingPoints = Math.max(0, trainingPoints - amount);
        tpSpentToday += amount;
    }
    public int getTpSpentToday() {
        return tpSpentToday;
    }
    public int getDailyTpLimit() {
        return level * 20;
    }
}
