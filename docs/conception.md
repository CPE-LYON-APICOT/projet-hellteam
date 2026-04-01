# Conception technique

> Ce document décrit l'architecture technique de votre projet. Vous êtes dans le rôle du lead-dev / architecte. C'est un document technique destiné à des développeurs.



```
- Factory pour créer les ennemis
- Pattern Decorateur permettant de rendre invincible, de tirer 2 fois plus vite, de faire autre chose temporairement...
- Singleton des stats qui augmente le score, ...
- Classe qui régit les power-ups (Strategy)
- Quand un ennemi est touché, un DP Observer fait un son
- Un ennemi a un attribut qui pointe vers une interface EnemyStrategy qui doit être implémenté par au moins 2 classes de strategy. L'implémentation est choisie au RunTime
```

## Vue d'ensemble

<!-- Décrivez les grandes briques de votre application et comment elles communiquent. Un schéma d'architecture est bienvenu. -->

## Design Patterns

### DP 1 — *Pattern Strategy* (implémenté dans le diagramme de classes)

**Feature associée** : Création des vaisseaux ennemis 

**Justification** : Lorsque le système crée un ennemi, on souhaite pouvoir définir avec un ennemi avec un comportement particulier ou un autre comportement, dans des classes Strategy isolant et définissant ce comportement.
Par exemple, on aura une interface Enemy Strategy qui pourra être implémentée par des classes BossStrategy qui l'implémentera (qui définira des stats boostées, des capacités à tirer plusieurs fois), ou une autre classe BasicEnemyStrategy (qui définira le comportement d'un vaisseau ennemi classique), ...

**Intégration** : 
<!-- Comment s'intègre-t-il dans l'architecture ? -->

### DP 2 — *Pattern Observer* 

**Feature associée** : Sons joués lors d'événements dans le jeu 

**Justification** : On souhaite pouvoir jouer des sons lorsqu'un ennemi est tué (voire touché), lorsque l'un des deux joueurs meurt, lorsqu'on atteint une jauge dans le score, ... L'intérêt ici est d'utiliser un Observer qui va être capable de détecter l'événement représentant la mort d'un ennemi, un ennemi touché, un allié mort, un score atteint, ...  

**Intégration** : 

### DP 3 — *Pattern Singleton* (implémenté dans le diagramme de classes)

**Feature associée** : Tableau de scores de la partie

**Justification** : Dans les fonctionnalités sont voulues un tableau de statistiques affichées sur l'écran. On n'a besoin de l'instancier qu'une fois, et les appels seront effectués à cette instance. Ainsi, on va utiliser une classe utilisant un DP Singleton qui disposera de méthodes pouvant être appellées pour lui envoyer des statistiques.

**Intégration** : 

### DP 4 — *Pattern Factory* (implémenté dans le diagramme de classes)

**Feature associée** : Création d'ennemis variés  

**Justification** : On a besoin d'un système permettant de créer facilement et rapidement de divers ennemis. Ainsi, on va créer une EnemyFactory, qui sera responsable de créer les ennemis en fonction de ce qui lui est demandé. Par exemple, une méthode dans la Factory qui renverra un boss, 

**Intégration** : 

### DP 5 - *Pattern Decorator* (quasiment implémenté dans le diagramme de classes)

**Feature associée** : Application d'upgrades par intermittence aux joueurs alliés

**Justification** : Sachant qu'on souhaite pouvoir ajouter de temps à autre des upgrades aux deux joueurs, on va utiliser un pattern Decorator dans ce sens. Il empilera les upgrades une par une, et les stats seront calculées conséquence.

**Intégration** :

## Diagrammes UML

### Diagramme 1 — *Classe*

Diagramme non terminé, mais un commentaire sera apprécié !

```plantuml
@startuml

title ProjetHellTeam
''' Envisager dans la méthode le fait que calculerProximite prendra en paramètre des objets avec des coordonées et non les coordonées elle meme'''
class Game {
  + List<AllyShip> allyShips
  + List<Enemy> enemyShips
  + List<AllyProjectile> currentAllyProjectiles
  + List<EnemyProjectile> currentEnemyProjectiles
  
  + calculerProjectilsAtteintsEnnemisEtAllies()
  + calculerProximite(x1, y1, x2, y2):bool
  + observers : List<GameObserver>
  + subscribe(GameObserver o)
  + unsubscribe(GameObserver o)
  + notifierObserveurs()


}

interface GameObserver {
  + onEvent(e:GameEvent):void
}

class SoundObserver implements GameObserver
{
}

class ScoreObserver implements GameObserver
{
}

enum GameEvent{
  ENEMY_HIT
  ENEMY_KILLED
  PLAYER_DIED
  SCORE_TRESHOLD
  }

interface EnemyStrategy{
}

abstract class Enemy{
  'Pas encore de liste exhaustive de types d ennemis : va évoluer au fur et à mesure du jeu'
  # EnemyStrategy strategy
  # int speed
  # int hp
  # int projectileDamage
  # int x
  # int y
}


abstract class Projectile {
  # int speed
  # int width
  # int x
  # int y
}

class AllyProjectile extends Projectile{
}

class EnemyProjectile extends Projectile{
}
class HeavyEnemy extends Enemy{
}

class LightEnemy extends Enemy{
}


class RapidFireEnemyStrategy implements EnemyStrategy {
}

class RandomFireEnemyStrategy implements EnemyStrategy{
}

class StraightFireStrategy implements EnemyStrategy{
}

class ScoreData{
  'Singleton'
  - score
  - vagueActuelle
  + ScoreData getInstance()
  + void addPointsToScore(int)
  + void removePointsFromScore(int)
  + void resetStats()
}

class EnemyFactory{
  'Cette liste de création d ennemis n est pas exhaustive, elle va évidemment évoluer le long du projet'
  + Enemy createHeavyEnemy()
  + Enemy createLightEnemy()
}

class AllyShip{
  + Int speed
  + Int hp
  + Int projectileDamage
  + Int reloadTime
  + int x
  + int y
}

abstract class ShipUpgrade extends AllyShip{
  # AllyShip upgradedShip  
}

class HPShipUpgrade extends ShipUpgrade{
  - HPShipUpgrade(AllyShip ship)
}

class SpeedShipUpgrade extends ShipUpgrade {

}

class ProjectileDamageShipUpgrade extends ShipUpgrade {
}

class ReloadTimeUpgrade extends ShipUpgrade {
}




Game --o AllyProjectile : has
Game --o EnemyProjectile : has 
Game --o AllyShip : has
Game --> GameObserver : notifie
@enduml


```
![img_1.png](img_1.png)

### Diagramme 2 — *Activité*
```plantuml
@startuml

start
:L'utilisateur arrive sur le menu;

if (Combien de joueurs ?) then (2 joueurs)
  :Démarrer partie (2 joueurs, plus difficile);
else (1 joueur)
  :Démarrer partie (1 joueur);
endif

:Apparition des vaisseaux et de l'interface (Score);

repeat :Apparition et actions des ennemis;
  
  :Actions des joueurs (Déplacements, Tirs incluant tir ami);
  :Sons d'événements et Mise à jour du score;

  if (Tous les joueurs sont morts ?) then (Oui)
    :Écran de Défaite;
    :Retour au menu;
    stop
  elseif (Toutes les vagues sont terminées ?) then (Oui)
    :Écran de Victoire;
    :Retour au menu;
    stop
  elseif (Vague intermédiaire terminée/Temps défini atteint ?) then (Oui)
    :Choix d'une Upgrade (NumPad);
  else (La vague en cours continue)
  endif

repeat while (Partie en cours)

@enduml
```
![img.png](img.png)
