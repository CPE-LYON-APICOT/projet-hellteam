package fr.cpe.model;

abstract public class SpacialObject {
    public double x;
    public double y;
    public int speed;
    public double angle = 0 ;// Direction étant pour l'instant définie de 0 a 360 degrés
    public static final double ROTATION_SPEED = 1.0;

    public SpacialObject(double x, double y, double direction, int speed) {
        this.x = x;
        this.y = y;
        this.angle = direction;
        this.speed = speed;
    }
}
