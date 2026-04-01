package fr.cpe.model;

public class ScoreDataSingleton {
    int score;
    int maxScore;
    int enemiesKilled;
    int timeElapsed;
    // currentWave : envisager système de vagues
    // enemiesRemainingForWave

    private static ScoreDataSingleton instance;
    // Considérer le système de vagues ?

    private ScoreDataSingleton()
    {
    }
    public static ScoreDataSingleton getInstance()
    {
        if (instance==null)
        {
            instance = new ScoreDataSingleton();
        }
        return instance;
    }
}


