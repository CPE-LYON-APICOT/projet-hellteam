package fr.cpe.service;

import fr.cpe.engine.InputService;
import fr.cpe.model.EventService;
import fr.cpe.model.ScoreDataSingleton;
import javafx.scene.layout.Pane;

public class ScoreService {
    private ScoreDataSingleton scoreDataSingleton = ScoreDataSingleton.getInstance();
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

            }
        });

    }
    public void init(Pane gamePane)
    {
    }
}
