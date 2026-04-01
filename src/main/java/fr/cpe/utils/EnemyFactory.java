package fr.cpe.utils;

import fr.cpe.model.ClassicEnemy;
import fr.cpe.model.Enemy;
import fr.cpe.model.HeavyEnemy;
import fr.cpe.model.LightEnemy;
import java.util.Random;

public class EnemyFactory {

    static public Enemy CreateEnemy(double x, double y, int direction, int speed) {
        Random random = new Random(System.currentTimeMillis());
        int rand = random.nextInt(3) + 1;

        return switch (rand) {
            case 1 -> new ClassicEnemy(x, y, direction, speed);
            case 2 -> new LightEnemy(x, y, direction, speed);
            case 3 -> new HeavyEnemy(x, y, direction, speed);
            default -> null;
        };
    }
}