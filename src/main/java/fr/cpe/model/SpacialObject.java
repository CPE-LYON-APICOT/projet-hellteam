package fr.cpe.model;

abstract public class SpacialObject {
    public double x;
    public double y;
    public int speed;
    public int direction;// Direction étant pour l'instant définie de 0 a 360 degrés

    public SpacialObject(double x, double y, int direction, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }
}
