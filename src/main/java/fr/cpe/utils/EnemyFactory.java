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
            case 1 -> new ClassicEnemy(0, 0, 0, 0);
            case 2 -> new LightEnemy(0, 0, 0, 0);
            case 3 -> new HeavyEnemy(0, 0, 0, 0);
            default -> null;
        };
    }
}