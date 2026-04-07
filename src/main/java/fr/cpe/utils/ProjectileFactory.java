package fr.cpe.utils;

import fr.cpe.model.AllyProjectile;
import fr.cpe.model.Projectile;
import fr.cpe.model.EnemyProjectile;

public class ProjectileFactory {
    public static Projectile CreateAllyProjectile(double x, double y, int direction, int speed) {
        return new AllyProjectile(x, y, direction, speed);
    }

    public static Projectile CreateEnemyProjectile(double x, double y, int direction, int speed) {
        return new EnemyProjectile(x, y, direction, speed);
    }
}
