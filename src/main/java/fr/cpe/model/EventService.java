package fr.cpe.model;

import fr.cpe.service.IEventsObserver;
import jakarta.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class EventService {
    private ArrayList<IEventsObserver> observers = new ArrayList<>();

    public void addObserver(IEventsObserver observer) {
        observers.add(observer);
    }


    public void onEnemyDestroyed() {
        for (IEventsObserver observer : observers) {
            observer.onEnemyDestroyed();
        }
    }


    public void onAllyDestroyed() {
        observers.forEach(IEventsObserver::onAllyDestroyed);
    }

    public void onShoot() {
        for (IEventsObserver observer : observers) {
            observer.onShoot();
        }
    }
}
