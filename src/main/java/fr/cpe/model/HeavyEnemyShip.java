package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;

public class HeavyEnemyShip extends EnemyShip {
    public HeavyEnemyShip(double x, double y, int direction, int speed, int hp, int maxHp, int reloadTime, EnemyStrategy strategy) {
        super(x, y, direction, speed, hp, maxHp, reloadTime, strategy);
    }
    @Override
    public String getType() {
        return "HeavyEnemy";
    }
}
