package fr.cpe.model;

public class AllyShip extends Ship {
    public int hp;
    public int maxHp;
    public int reloadTime;

    public AllyShip(double x, double y, double angle, int speed, int hp, int maxHp, int reloadTime) {
        super(x, y, angle, speed, hp, maxHp, reloadTime);
    }
}
