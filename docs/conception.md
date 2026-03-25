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

### DP 1 — *Pattern Strategy*

**Feature associée** : Création des vaisseaux ennemis 

**Justification** : Lorsque le système crée un ennemi, on souhaite pouvoir définir avec un ennemi avec un comportement particulier ou un autre comportement, dans des classes Strategy isolant et définissant ce comportement.
Par exemple, on aura une interface Enemy Strategy qui pourra être implémentée par des classes BossStrategy qui l'implémentera (qui définira des stats boostées, des capacités à tirer plusieurs fois), ou une autre classe BasicEnemyStrategy (qui définira le comportement d'un vaisseau ennemi classique), ...

**Intégration** : 
<!-- Comment s'intègre-t-il dans l'architecture ? -->

### DP 2 — *Pattern Observer*

**Feature associée** : Sons joués lors d'événements dans le jeu 

**Justification** : On souhaite pouvoir jouer des sons lorsqu'un ennemi est tué (voire touché), lorsque l'un des deux joueurs meurt, lorsqu'on atteint une jauge dans le score, ... L'intérêt ici est d'utiliser un Observer qui va être capable de détecter l'événement représentant la mort d'un ennemi, un ennemi touché, un allié mort, un score atteint, ...  

**Intégration** : 

### DP 3 — *Pattern Singleton*

**Feature associée** : Tableau de scores de la partie

**Justification** : Dans les fonctionnalités sont voulues un tableau de statistiques affichées sur l'écran. On n'a besoin de l'instancier qu'une fois, et les appels seront effectués à cette instance. Ainsi, on va utiliser une classe utilisant un DP Singleton qui disposera de méthodes pouvant être appellées pour lui envoyer des statistiques.

**Intégration** : 

### DP 4 — *Pattern Factory*

**Feature associée** : On a besoin d'un système permettant de créer facilement un enemy sans avoir besoin de connaître toutes ces fonctionnalités

**Justification** : On 

**Intégration** : 

## Diagrammes UML

### Diagramme 1 — *Type (classe, séquence, cas d'utilisation…)*

<!-- Exemple de syntaxe PlantUML (à remplacer par votre diagramme) :

```plantuml
@startuml
interface Drawable {
    + draw(gc : GraphicsContext) : void
}

abstract class Entity {
    - x : double
    - y : double
    + getX() : double
    + getY() : double
    + update() : void
}

Entity ..|> Drawable

class Player extends Entity {
    - speed : double
    + move(direction : Direction) : void
}

class Obstacle extends Entity {
    - damage : int
}
@enduml
```

Ceci est un exemple, remplacez-le par votre propre diagramme. -->

```plantuml
@startuml

@enduml
```

### Diagramme 2 — *Type*

```plantuml
@startuml

@enduml
```

