package fr.cpe.service;

import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.ScoreDataSingleton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ScoreService {
    private final ScoreDataSingleton scoreDataSingleton = ScoreDataSingleton.getInstance();
    private Text scoreText;
    @Inject
    public ScoreService(EventService eventService, InputService inputService)
    {
        eventService.addObserver(new IEventsObserver() {
            @Override
            public void onEnemyDestroyed() {
                scoreDataSingleton.score += 100;
                scoreDataSingleton.enemiesKilled++;
            }

            @Override
            public void onAllyDestroyed() {
                scoreDataSingleton.score -= 50;
            }

            @Override
            public void onShoot() {
                // Aucune action nécessaire pour le tableau de scores
            }
        });
        scoreText = new Text(670, 14, "Score " + scoreDataSingleton.score+ " | Enemies killed : " + scoreDataSingleton.enemiesKilled+ " | Time : " + scoreDataSingleton.timeElapsed);
        scoreText.setFill(Color.RED);


    }
    public void init(Pane gamePane)
    {
        // 670-14 coordonées panneau de score
        gamePane.getChildren().add(scoreText);
    }

    public void update()
    {
        scoreDataSingleton.timeElapsed += (1.0/60.0); // Simule le temps écoulé (en secondes)
        scoreText.setText("Score " + scoreDataSingleton.score+ " | Enemies killed : " + scoreDataSingleton.enemiesKilled+ " | Time : " + scoreDataSingleton.timeElapsed);
    }
}
