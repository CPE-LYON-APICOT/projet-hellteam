package fr.cpe.model;

public class HeavyEnemy extends Enemy{
    public HeavyEnemy (double x, double y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    @Override
    public String getType() {
        return "HeavyEnemy";
    }
}
