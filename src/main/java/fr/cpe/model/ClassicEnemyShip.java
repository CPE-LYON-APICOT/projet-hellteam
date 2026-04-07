package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;

public class ClassicEnemyShip extends EnemyShip {
    public ClassicEnemyShip(double x, double y, int angle, int speed, int hp, int maxHp, int reloadTime, EnemyStrategy strategy) {
        super(x, y, angle, speed, hp, maxHp, reloadTime, strategy);
    }

    @Override
    public String getType() {
        return "ClassicEnemy";
    }
}
