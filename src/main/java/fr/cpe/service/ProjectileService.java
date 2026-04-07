package fr.cpe.service;

import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.AllyShip;
import fr.cpe.model.SpacialObject;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Objects;
import java.util.Random;

public class ProjectileService {
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
    public ProjectileService(InputService inputService) {
        this.inputService = inputService;
    }

    /**
     * Crée la balle (modèle + vue) et l'ajoute au Pane.
     */
    public void init(Pane gamePane) {

        this.gamePaneInstance = gamePane;
    }



    public void update() {

    }

    public Image returnAllyProjectileImage(){
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/alyproj.png")));
    }

    private Image returnEnemyProjectileImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemyproj.png")));
    }
}
