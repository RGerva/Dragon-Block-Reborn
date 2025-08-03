package com.rgerva.dbr.mechanics;

public interface IPlayerStatCapability {
    ModStats.ModAttributes getAttributes();
    void setAttributes(ModStats.ModAttributes attributes);

    ModStats.RaceType getRace();
    void setRace(ModStats.RaceType race);

    ModStats.ClassType getClazz();
    void setClazz(ModStats.ClassType clazz);

    float getPowerRelease();
    void setPowerRelease(float powerRelease);

    int getTrainingPoints();
    void addTrainingPoints(int amount);
    void spendTrainingPoints(int amount);
    int getTpSpentToday();
    int getDailyTpLimit();
}
