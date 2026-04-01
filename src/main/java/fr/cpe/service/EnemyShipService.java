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
    private HBox enemyContainer; // Conteneur pour les ennemis

    public void init(Pane gamePane) {
        enemyList = new ArrayList<>();
        enemyContainer = new HBox(10); // Espacement de 10 pixels entre chaque ennemi

        // Crée 5 ennemis
        for (int i = 0; i < 10; i++) {
            Enemy enemy = EnemyFactory.CreateEnemy(10.0, 20.0, 1, 5);
            if (enemy != null) { // Vérifie que l'ennemi n'est pas null
                enemyList.add(enemy);
                Image enemyImage = getImageForEnemy(enemy);
                ImageView imageView = new ImageView(enemyImage);
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);
                enemyContainer.getChildren().add(imageView);
            }
        }

        // Ajoute le conteneur des ennemis au Pane principal
        gamePane.getChildren().add(enemyContainer);
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