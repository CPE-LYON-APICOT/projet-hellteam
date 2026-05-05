package fr.cpe.service;

import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.*;
import fr.cpe.utils.ProjectileFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.*;

public class ProjectileService {
    private final InputService inputService;
    private final EventService eventService;
    private AllyShipService allyShipService;
    private long lastShootTime = 0;
    private Pane gamePaneInstance;
    private Map<AllyProjectile, ImageView> projectileAllyMap = new HashMap<>();
    private Map<EnemyProjectile, ImageView> projectileEnemyMap = new HashMap<>();

    @Inject
    public ProjectileService(InputService inputService, EventService eventService) {
        this.inputService = inputService;
        this.eventService = eventService;
    }

    public void init(Pane gamePane, AllyShipService allyShipService) {
        this.gamePaneInstance = gamePane;

        this.allyShipService = allyShipService;
        projectileAllyMap = new HashMap<>();
        projectileEnemyMap = new HashMap<>();
    }


    public void update(double width, double height) {
        // Met à jour la position des projectiles alliés
        for (Map.Entry<AllyProjectile, ImageView> entry : projectileAllyMap.entrySet()) {
            AllyProjectile projectile = entry.getKey();
            ImageView imageView = entry.getValue();

            projectile.x += Math.cos(Math.toRadians(projectile.angle)) * projectile.speed;
            projectile.y += Math.sin(Math.toRadians(projectile.angle)) * projectile.speed;

            imageView.setX(projectile.x);
            imageView.setY(projectile.y);
        }

        // Crée un projectile pour les deux alliés

        long now = System.currentTimeMillis();

        if (now - lastShootTime >= 1000) {
            lastShootTime = now;

            Projectile projectile = ProjectileFactory.CreateAllyProjectile(allyShipService.getPlayer1());
            ImageView imageViewProjectile = new ImageView(returnAllyProjectileImage());
            imageViewProjectile.setFitWidth(20);
            imageViewProjectile.setFitHeight(20);
            imageViewProjectile.setX(projectile.x);
            imageViewProjectile.setY(projectile.y);
            imageViewProjectile.setRotate(projectile.angle);
            gamePaneInstance.getChildren().add(imageViewProjectile);
            projectileAllyMap.put((AllyProjectile) projectile, imageViewProjectile);

            if (allyShipService.isTwoPlayers()) {
                Projectile projectile2 = ProjectileFactory.CreateAllyProjectile(allyShipService.getPlayer2());
                ImageView imageViewProjectile2 = new ImageView(returnAllyProjectileImage());
                imageViewProjectile2.setFitWidth(20);
                imageViewProjectile2.setFitHeight(20);
                imageViewProjectile2.setX(projectile2.x);
                imageViewProjectile2.setY(projectile2.y);
                imageViewProjectile2.setRotate(projectile2.angle);
                gamePaneInstance.getChildren().add(imageViewProjectile2);
                projectileAllyMap.put((AllyProjectile) projectile2, imageViewProjectile2);
            }
            eventService.onShoot();
        }
    }

    public Image returnAllyProjectileImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/alyproj.png")));
    }

    private Image returnEnemyProjectileImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyproj.png")));
    }
}
