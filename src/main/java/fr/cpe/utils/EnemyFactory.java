package fr.cpe.utils;

import fr.cpe.model.ClassicEnemyShip;
import fr.cpe.model.EnemyShip;
import fr.cpe.model.HeavyEnemyShip;
import fr.cpe.model.LightEnemyShip;
import java.util.Random;

public class EnemyFactory {

    static public EnemyShip CreateEnemy(double x, double y, int angle, int speed, int hp, int maxHp, int reloadTime) {
        Random random = new Random(System.currentTimeMillis());
        int rand = random.nextInt(3) + 1;

        return switch (rand) {
            case 1 -> new ClassicEnemyShip(x, y, angle, speed, hp, maxHp, reloadTime, null);
            case 2 -> new LightEnemyShip(x, y, angle, speed, hp, maxHp, reloadTime, null);
            case 3 -> new HeavyEnemyShip(x, y, angle, speed, hp, maxHp, reloadTime, null);
            default -> null;
        };
    }
}