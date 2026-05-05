package fr.cpe.service;

public interface IEventsObserver {
    public void onEnemyDestroyed();
    public void onAllyDestroyed();
    public void onShoot();
}
