package fr.cpe.model;

import fr.cpe.utils.EnemyStrategy;
abstract public class Enemy extends SpacialObject{
    public EnemyStrategy strategy;
    public Enemy(double x, double y, int direction, int speed) {
        super(x, y, direction, speed);
    }
}
