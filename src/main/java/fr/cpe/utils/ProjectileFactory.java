package fr.cpe.utils;

import fr.cpe.model.AllyProjectile;
import fr.cpe.model.Projectile;
import fr.cpe.model.EnemyProjectile;
import fr.cpe.model.Ship;

public class ProjectileFactory {
    public static Projectile CreateAllyProjectile(double x, double y, int direction, int speed, Ship launcher) {
        return new AllyProjectile(x, y, direction, speed, launcher);
    }

    public static Projectile CreateEnemyProjectile(double x, double y, int direction, int speed, Ship launcher) {
        return new EnemyProjectile(x, y, direction, speed, launcher);
    }
}
