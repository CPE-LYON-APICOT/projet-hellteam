package fr.cpe.utils;

import fr.cpe.model.AllyProjectile;
import fr.cpe.model.Projectile;
import fr.cpe.model.EnemyProjectile;
import fr.cpe.model.Ship;

public class ProjectileFactory {
    private static final int OFFSET = 20;

    public static Projectile CreateAllyProjectile(Ship launcher) {
        // 1. Récupérer les données du vaisseau
        double shipX = launcher.x;
        double shipY = launcher.y;
        double angle = launcher.angle;
        int speed = 10; // Exemple de vitesse par défaut

        // 2. Calculer le décalage (Offset) en fonction de l'angle
        double radians = Math.toRadians(angle);
        double spawnX = shipX + Math.cos(radians) * OFFSET;
        double spawnY = shipY + Math.sin(radians) * OFFSET;

        // 3. Créer le projectile à la nouvelle position
        return new AllyProjectile(spawnX, spawnY, launcher.angle, speed, launcher);
    }

    public static Projectile CreateEnemyProjectile(int x, int y, int angle, int speed, Ship launcher) {
        return new EnemyProjectile(x, y, angle, speed, launcher);
    }
}
