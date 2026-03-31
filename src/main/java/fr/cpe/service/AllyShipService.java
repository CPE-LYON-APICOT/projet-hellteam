package fr.cpe.service;
import com.google.inject.Inject;


import com.google.inject.Inject;
import fr.cpe.engine.InputService;
import fr.cpe.model.Ball;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import fr.cpe.model.AllyShip;

public class AllyShipService {
    private AllyShip ship;
    private final InputService inputService;

    @Inject
    public AllyShipService(InputService inputService){this.inputService = inputService;}

    public void init(Pane gamePane)
    {
    }
}
