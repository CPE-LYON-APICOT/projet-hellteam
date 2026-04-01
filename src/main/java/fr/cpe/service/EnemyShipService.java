package fr.cpe.service;
import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.Ball;
import fr.cpe.model.Enemy;
import fr.cpe.utils.EnemyFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;
import java.util.Objects;

public class EnemyShipService {
    private List<Enemy> enemyList;

    public void init(Pane gamePane) {
        EnemyFactory factory = new EnemyFactory();

        Enemy Enemy = EnemyFactory.CreateEnemy(0,0,0,0);



    }

    public Image returnEnemyShipImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyShip.png")));
    }

    public Image returnEnemyShipHeavyImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyShipHeavy.png")));
    }

    public Image returnEnemyShipLightImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyShipLight.png")));
    }

    public Image returnEnemyProjectileImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyproj.png")));
    }
}
