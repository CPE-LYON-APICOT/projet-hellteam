package fr.cpe.utils;

import fr.cpe.model.Ship;

import java.util.List;

public class RandomShootingEnemyStrategy implements EnemyStrategy{

    @Override
    public void shoot(Ship enemyShooter, List<Ship> allies, List<Ship> enemies) {
            if (!enemies.isEmpty()) {
                int randomIndex = (int) (Math.random() * enemies.size());
                Ship target = enemies.get(randomIndex);
                //enemyShooter.shoot(target);
            }
    }
}
