package fr.cpe.model;

public class AllyShip extends SpacialObject {
    public int hp;
    public int maxHp;
    // reloadTime ?
    public AllyShip(double x, double y, int direction, int speed) {
        super(x, y, direction, speed);
    }
}
