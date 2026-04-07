package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;

public class LightEnemyShip extends EnemyShip {
    public LightEnemyShip(double x, double y, int angle, int speed, int hp, int maxHp, int reloadTime, EnemyStrategy strategy) {
        super(x, y, angle, speed, hp, maxHp, reloadTime, strategy);
    }
    @Override
    public String getType() {
        return "LightEnemy";
    }
}
