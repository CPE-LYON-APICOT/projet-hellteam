package fr.cpe.utils;

import fr.cpe.model.Ship;

import java.util.List;

public interface EnemyStrategy {
    public void shoot(Ship enemyShooter, List<Ship> allies, List<Ship> enemies);
}
