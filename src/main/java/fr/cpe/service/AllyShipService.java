package fr.cpe.service;

// ╔══════════════════════════════════════════════════════════════════════════════╗
// ║                                                                            ║
// ║   ✏️  FICHIER MODIFIABLE — Exemple de service injecté par Guice            ║
// ║                                                                            ║
// ║   Montre comment gérer un élément du jeu (modèle + vue + événements)      ║
// ║   dans un seul service. Remplacez-le par vos propres services.             ║
// ║                                                                            ║
// ╚══════════════════════════════════════════════════════════════════════════════╝

import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.AllyShip;
import fr.cpe.model.Ball;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Service d'exemple — gère entièrement la balle : modèle, vue et événements.
 *
 * <p>C'est un <strong>exemple</strong> de service injecté par Guice dans GameService.
 * Il montre comment regrouper dans un même endroit :</p>
 * <ul>
 *   <li>Le <strong>modèle</strong> ({@link Ball}) — données du jeu</li>
 *   <li>La <strong>vue</strong> ({@link Circle}) — représentation visuelle</li>
 *   <li>Les <strong>événements</strong> — clavier (flèches) + clic souris</li>
 * </ul>
 *
 * <p>GameService reçoit ce service via {@code @Inject} dans son constructeur :</p>
 * <pre>
 *   @Inject
 *   public GameService(BallService ballService) { ... }
 * </pre>
 */

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class AllyShipService {


    private final InputService inputService;
    private ImageView ballNode;  // Circle → ImageView
    private AllyShip ship;
    @Inject
    public AllyShipService(InputService inputService) {
        this.inputService = inputService;
    }

    /**
     * Crée la balle (modèle + vue) et l'ajoute au Pane.
     */
    public void init(Pane gamePane) {
        ship = new AllyShip(0, 0, 1, 1);
        // Charge l'image depuis les resources
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dfff.png")));
        ballNode = new ImageView(image);

        // Position initiale (ImageView se positionne par son coin supérieur gauche)
        ballNode.setX(0);
        ballNode.setY(0);

        // Clic sur la balle → changement de couleur via ColorAdjust
        ballNode.setOnMouseClicked(e -> applyRandomHue());
        ballNode.setFitWidth(60);
        ballNode.setFitHeight(60);
        gamePane.getChildren().add(ballNode);
    }

    public void update() {

        if (inputService.isKeyPressed(KeyCode.LEFT))  ship.x-=1;
        if (inputService.isKeyPressed(KeyCode.RIGHT)) ship.x+=1;
        if (inputService.isKeyPressed(KeyCode.UP))    ship.y-=1;
        if (inputService.isKeyPressed(KeyCode.DOWN))  ship.y+=1;

        ballNode.setX(ship.x);
        ballNode.setY(ship.y);

        /*if (inputService.isKeyPressed(KeyCode.LEFT))  ball.dx -= ACCELERATION;
        if (inputService.isKeyPressed(KeyCode.RIGHT)) ball.dx += ACCELERATION;
        if (inputService.isKeyPressed(KeyCode.UP))    ball.dy -= ACCELERATION;
        if (inputService.isKeyPressed(KeyCode.DOWN))  ball.dy += ACCELERATION;

        ball.x += ball.dx;
        ball.y += ball.dy;

        boolean bounced = false;

        if (ball.x - RADIUS < 0 || ball.x + RADIUS > width) {
            ball.dx = -ball.dx;
            bounced = true;
        }
        if (ball.y - RADIUS < 0 || ball.y + RADIUS > height) {
            ball.dy = -ball.dy;
            bounced = true;
        }

        if (bounced) applyRandomHue();

        // Synchronise modèle → vue (coin sup. gauche = centre - rayon)
        ballNode.setX(ball.x - RADIUS);
        ballNode.setY(ball.y - RADIUS);
        // Synchronise modèle → vue
        ballNode.setX(ball.x - RADIUS);
        ballNode.setY(ball.y - RADIUS);

// Calcul de l'angle en degrés
        double angle = Math.toDegrees(Math.atan2(ball.dy, ball.dx));
        ballNode.setRotate(angle);*/
    }

    /** Applique une teinte aléatoire à l'image via un filtre ColorAdjust. */
    private void applyRandomHue() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(Math.random() * 2 - 1); // valeur entre -1.0 et 1.0
        ballNode.setEffect(colorAdjust);
    }
}