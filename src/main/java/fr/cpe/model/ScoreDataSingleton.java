package fr.cpe.model;

public class ScoreDataSingleton {
    int score;
    ScoreDataSingleton instance;
    // Considérer le système de vagues ?

    ScoreDataSingleton getInstance()
    {
        if (instance==null)
        {
            instance = new ScoreDataSingleton();
        }
        return instance;
    }
}
