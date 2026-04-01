package fr.cpe.service;
import fr.cpe.model.Enemy;
import fr.cpe.utils.EnemyFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnemyShipService {
    private List<Enemy> enemyList;

    public void init(Pane gamePane) {
        enemyList = new ArrayList<>();

        // Crée 5 ennemis et les place dans le Pane
        for (int i = 0; i < 10; i++) {
            Enemy enemy = EnemyFactory.CreateEnemy(10.0 + (i * 80), 40.0, 1, 5); // Décale chaque ennemi horizontalement
            if (enemy != null) {
                enemyList.add(enemy);
                Image enemyImage = getImageForEnemy(enemy);
                ImageView imageView = new ImageView(enemyImage);
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);

                // Positionne l'ennemi dans le Pane
                System.out.println("x"+enemy.x+"y"+enemy.y);
                imageView.setLayoutX(enemy.x);
                imageView.setLayoutY(enemy.y);

                // Ajoute l'ImageView au Pane
                gamePane.getChildren().add(imageView);
            }
        }
    }

    private Image getImageForEnemy(Enemy enemy) {
        String imagePath = switch (enemy.getType()) {
            case "ClassicEnemy" -> "/images/enemyShip.png";
            case "LightEnemy" -> "/images/enemyShipLight.png";
            case "HeavyEnemy" -> "/images/enemyShipHeavy.png";
            default -> throw new IllegalStateException("Type d'ennemi inconnu : " + enemy.getType());
        };
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
    }
}