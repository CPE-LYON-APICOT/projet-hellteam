package fr.cpe.model;

abstract public class Projectile extends SpacialObject{
    public Projectile(double x, double y, int direction, int speed) {
        super(x, y, direction, speed);
    }
}
