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
import javafx.scene.text.Text;

import java.util.Objects;
import java.util.Random;

public class AllyShipService {


    private final InputService inputService;
    private ImageView shipNodeJ1;  // Circle → ImageView
    private ImageView shipNodeJ2;
    private AllyShip ship1;
    private AllyShip ship2;
    private boolean twoPlayers = false;
    private Text text;
    private Text textJ2;
    @Inject
    public AllyShipService(InputService inputService) {
        this.inputService = inputService;
    }

    /**
     * Crée la balle (modèle + vue) et l'ajoute au Pane.
     */
    public void init(Pane gamePane) {
        int random = new Random().nextInt(2) + 1;
        System.out.println(random);
        if (random ==1) twoPlayers = true; // Vérifie si joueur 2 accepté
        ship1 = new AllyShip(0, 0, 1, 1);
        // Charge l'image depuis les resources
        Image image = returnAllyShipImage();
        shipNodeJ1 = new ImageView(image);
        shipNodeJ1.setX(ship1.x);
        shipNodeJ1.setY(ship1.y);

        // Clic sur la balle → changement de couleur via ColorAdjust
        shipNodeJ1.setFitWidth(60);
        shipNodeJ1.setFitHeight(60);
        text = new Text(20, 30, ""+ ship1.x+ ship1.y);
        gamePane.getChildren().add(shipNodeJ1);
        gamePane.getChildren().add(text);


        if (twoPlayers)
        {
            ship2 = new AllyShip(200,200,1,1);
            shipNodeJ2 = new ImageView(image);
            shipNodeJ2.setX(ship2.x);
            shipNodeJ2.setY(ship2.y);
            shipNodeJ2.setFitWidth(60);
            shipNodeJ2.setFitHeight(60);
            textJ2 = new Text(20, 40, ""+ ship2.x+ ship2.y);
            gamePane.getChildren().add(shipNodeJ2);
            gamePane.getChildren().add(textJ2);
        }
    }


    public void update() {

        if (inputService.isKeyPressed(KeyCode.LEFT))  ship1.x-=1;
        if (inputService.isKeyPressed(KeyCode.RIGHT)) ship1.x+=1;
        if (inputService.isKeyPressed(KeyCode.UP))    ship1.y-=1;
        if (inputService.isKeyPressed(KeyCode.DOWN))  ship1.y+=1;

        if(twoPlayers) {
            if (inputService.isKeyPressed(KeyCode.Q)) ship2.x -= 1;
            if (inputService.isKeyPressed(KeyCode.D)) ship2.x += 1;
            if (inputService.isKeyPressed(KeyCode.Z)) ship2.y -= 1;
            if (inputService.isKeyPressed(KeyCode.S)) ship2.y += 1;

            text.setText("x: " + ship2.x + "  y: " + ship2.y);
            shipNodeJ2.setX(ship2.x);
            shipNodeJ2.setY(ship2.y);
        }
        text.setText("x: " + ship1.x + "  y: " + ship1.y);


        shipNodeJ1.setX(ship1.x);
        shipNodeJ1.setY(ship1.y);



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
        shipNodeJ1.setEffect(colorAdjust);
    }

    public Image returnAllyShipImage()
    {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dfff.png")));
    }

    public Image returnAllyProjectileImage(){
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/alyproj.png")));
    }
}