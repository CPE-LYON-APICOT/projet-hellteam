package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;

abstract public class EnemyShip extends Ship {
    public EnemyStrategy strategy;

    public EnemyShip(double x, double y, double direction, int speed, int hp, int maxHp, int reloadTime, EnemyStrategy strategy) {
        super(x, y, direction, speed, hp, maxHp, reloadTime);
        this.strategy = strategy;
    }
}
