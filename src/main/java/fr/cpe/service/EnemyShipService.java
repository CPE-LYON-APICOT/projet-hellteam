package fr.cpe.service;

import fr.cpe.model.EnemyShip;
import fr.cpe.utils.EnemyFactory;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnemyShipService {
    private List<EnemyShip> enemyShipList;

    public void init(Pane gamePane) {
        enemyShipList = new ArrayList<>();

        if (enemyShipList.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                EnemyShip enemyShip = EnemyFactory.CreateEnemy(10.0 + (i * 80), 40.0, 90, 5, 100, 100, 1);// Décale chaque ennemi horizontalement
                if (enemyShip != null) {
                    enemyShipList.add(enemyShip);
                    Image enemyImage = getImageForEnemy(enemyShip);
                    ImageView imageView = new ImageView(enemyImage);
                    imageView.setFitWidth(60);
                    imageView.setFitHeight(60);

                    // Positionne l'ennemi dans le Pane
                    System.out.println("x" + enemyShip.x + "y" + enemyShip.y);
                    imageView.setLayoutX(enemyShip.x);
                    imageView.setLayoutY(enemyShip.y);
                    imageView.setRotate(enemyShip.angle);

                    // Ajoute l'ImageView au Pane
                    gamePane.getChildren().add(imageView);
                }
            }
        }
    }


    //
    private Image getImageForEnemy(EnemyShip enemyShip) {
        String imagePath = switch (enemyShip.getType()) {
            case "ClassicEnemy" -> "/images/enemyShip.png";
            case "LightEnemy" -> "/images/enemyShipLight.png";
            case "HeavyEnemy" -> "/images/enemyShipHeavy.png";
            default -> throw new IllegalStateException("Type d'ennemi inconnu : " + enemyShip.getType());
        };
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
    }


}