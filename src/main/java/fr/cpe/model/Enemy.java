package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;

abstract public class Enemy extends SpacialObject implements EnemyStrategy {
    public EnemyStrategy strategy;
    public int hp;
    public int maxHp;
    public int reloadTime;

    public Enemy(double x, double y, double direction, int speed) {
        super(x, y, direction, speed);
    }

    public abstract String getType();
}
