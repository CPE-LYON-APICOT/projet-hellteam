package fr.cpe.model;

public class ScoreDataSingleton {
    public int score;
    int maxScore;
    public int enemiesKilled;
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

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }
}


