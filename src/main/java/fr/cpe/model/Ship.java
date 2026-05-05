package fr.cpe.model;

public class Ship extends SpacialObject{
    public int hp;
    public int maxHp;
    public int reloadTime;

    public Ship(double x, double y, double direction, int speed, int hp, int maxHp, int reloadTime) {
        super(x, y, direction, speed);
        this.hp = hp;
        this.maxHp = maxHp;
        this.reloadTime = reloadTime;
    }
}
