package fr.cpe.model;

public class LightEnemy extends Enemy{
    public LightEnemy (double x, double y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    @Override
    public String getType() {
        return "LightEnemy";
    }
}
