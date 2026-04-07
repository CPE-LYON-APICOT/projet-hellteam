package fr.cpe.utils;

import fr.cpe.model.Ship;

import java.util.List;

public class DefaultEnemyStrategy implements EnemyStrategy {

    @Override
    public void shoot(Ship enemyShooter, List<Ship> allies, List<Ship> enemies) {
        if (!allies.isEmpty()) {
            Ship closest = allies.get(0);
            double minDistance = distance(enemyShooter, closest);

            for (Ship ally : allies) {
                double dist = distance(enemyShooter, ally);
                if (dist < minDistance) {
                    minDistance = dist;
                    closest = ally;
                }
            }

            enemyShooter.shoot(closest);
        }
    }

    private double distance(Ship from, Ship to) {
        double dx = from.x - to.x;
        double dy = from.y - to.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
