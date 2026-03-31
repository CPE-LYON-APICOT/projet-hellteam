package fr.cpe.utils;

import fr.cpe.model.ClassicEnemy;
import fr.cpe.model.Enemy;


public class EnemyFactory {

    public Enemy CreateEnemy(double x, double y) {
        return new ClassicEnemy(0, 0, 0, 0);
    }
}