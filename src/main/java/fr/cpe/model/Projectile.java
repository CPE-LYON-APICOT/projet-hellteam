package fr.cpe.model;

abstract public class Projectile extends SpacialObject{
    Ship launcher;
    public Projectile(double x, double y, double direction, int speed, Ship launcher) {
        super(x, y, direction, speed);
        this.launcher = launcher;
    }
}
