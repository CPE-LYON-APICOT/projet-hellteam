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
import fr.cpe.model.SpacialObject;
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
import javafx.scene.text.Text;

import java.util.Objects;
import java.util.Random;

public class AllyShipService {


    private final InputService inputService;
    private Pane gamePaneInstance;
    private ImageView shipNodeJ1;  // Circle → ImageView
    private ImageView shipNodeJ2;
    private AllyShip ship1;
    private AllyShip ship2;
    private Image allyShipImage;
    private boolean twoPlayers = false;
    private Text textPositionShip1;
    private Text textPositionShip2;
    @Inject
    public AllyShipService(InputService inputService) {
        this.inputService = inputService;
    }

    /**
     * Crée la balle (modèle + vue) et l'ajoute au Pane.
     */
    public void init(Pane gamePane) {

        this.gamePaneInstance = gamePane;

        int random = new Random().nextInt(2) + 1;
        System.out.println(random);
        twoPlayers = (random == 1); // Vérifie si joueur 2 accepté
        ship1 = new AllyShip(0, 0, 1, 1, 100, 100, 1);
        // Charge l'image depuis les resources
        allyShipImage = returnAllyShipImage();
        shipNodeJ1 = new ImageView(allyShipImage);
        shipNodeJ1.setX(ship1.x);
        shipNodeJ1.setY(ship1.y);

        // Clic sur la balle → changement de couleur via ColorAdjust
        shipNodeJ1.setFitWidth(60);
        shipNodeJ1.setFitHeight(60);
        textPositionShip1 = new Text(20, 30, "x: " + ship1.x + "  y: " + ship1.y);
        textPositionShip1.setFill(Color.WHITE);
        gamePane.getChildren().add(shipNodeJ1);
        gamePane.getChildren().add(textPositionShip1);

        if (twoPlayers)
        {
            ship2 = new AllyShip(200,200,1,1, 100, 100, 1);
            shipNodeJ2 = new ImageView(allyShipImage);
            shipNodeJ2.setX(ship2.x);
            shipNodeJ2.setY(ship2.y);
            shipNodeJ2.setFitWidth(60);
            shipNodeJ2.setFitHeight(60);
            textPositionShip2 = new Text(20, 40, ""+ ship2.x+ ship2.y);
            textPositionShip2.setFill(Color.WHITE);
            gamePane.getChildren().add(shipNodeJ2);
            gamePane.getChildren().add(textPositionShip2);

            //instancierJoueur(shipNodeJ2, ship2, 20,40);
        }


    }



    public void update() {
        if (inputService.isKeyPressed(KeyCode.LEFT))  ship1.angle -= SpacialObject.ROTATION_SPEED;
        if (inputService.isKeyPressed(KeyCode.RIGHT)) ship1.angle += SpacialObject.ROTATION_SPEED;
        if (inputService.isKeyPressed(KeyCode.UP)) {
            ship1.x += Math.cos(Math.toRadians(ship1.angle));
            ship1.y += Math.sin(Math.toRadians(ship1.angle));
        }
        if (inputService.isKeyPressed(KeyCode.DOWN)) {
            ship1.x -= Math.cos(Math.toRadians(ship1.angle));
            ship1.y -= Math.sin(Math.toRadians(ship1.angle));
        }

        textPositionShip1.setText("x: " + ship1.x + "  y: " + ship1.y);


        shipNodeJ1.setX(ship1.x);
        shipNodeJ1.setY(ship1.y);

        shipNodeJ1.setRotate(ship1.angle);
        if(twoPlayers) {
            if (inputService.isKeyPressed(KeyCode.Q)) ship2.x -= 1;
            if (inputService.isKeyPressed(KeyCode.D)) ship2.x += 1;
            if (inputService.isKeyPressed(KeyCode.Z)) ship2.y -= 1;
            if (inputService.isKeyPressed(KeyCode.S)) ship2.y += 1;

            textPositionShip2.setText("x: " + ship2.x + "  y: " + ship2.y);
            shipNodeJ2.setX(ship2.x);
            shipNodeJ2.setY(ship2.y);
        }




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
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/defaultallyship.png")));
    }

    public Image returnAllyProjectileImage(){
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/alyproj.png")));
    }


    /*public void instancierJoueur(ImageView node, AllyShip ship, int XCooLocation, int YCooLocation)
    {
        ship = new AllyShip(200, 200, 1, 1);
        node.setImage(allyShipImage);
        node.setX(ship.x);
        node.setY(ship.y);
        node.setFitWidth(60);
        node.setFitHeight(60);

        Text text = new Text(XCooLocation, YCooLocation, "x: " + ship2.x + "  y: " + ship2.y);

        gamePaneInstance.getChildren().add(node);
        gamePaneInstance.getChildren().add(text);
    }*/
}