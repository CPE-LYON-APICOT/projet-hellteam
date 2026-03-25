# Pitch du projet

> Ce document présente votre projet à un client non-technique. Pas de jargon informatique, pas de code. On parle de fonctionnalités, de valeur ajoutée et de potentiel.

## Présentation générale

Le projet à réaliser se nomme **HellInvader**. Il s'agit d'un jeu rappelant le principe du jeu Space Invaders. 
Ce jeu, qui pourra se jouer seul ou à 2, consistera en le suivant : 
1 ou 2 joueurs atterisssent dans l'espace en contrôlant un vaisseau, et évoluent dans un espace défini dans lequel apparaissent des vaisseaux, météorites ennemis...
Le but est de battre les ennemis un par un et d'évoluer dans la difficulté, pour ainsi un niveau de fin défini.

## Fonctionnalités principales

<!-- Listez les fonctionnalités clés de votre projet. Pour chaque fonctionnalité, expliquez ce qu'elle apporte à l'utilisateur. -->

### Fonctionnalité 1 — *Contrôle de vaisseau*

1 ou 2 joueurs contrôlent un vaisseau dans un espace en deux dimensions avec les touches ZQSD ou/et flèches directionnelles. 
Ils évoluent dans les 3/4 inférieurs de la fenêtre
Ils peuvent avancer, reculer, tourner à gauche, à droite. Le canon, toujours orienté dans la direction dans laquelle avance le défaut, tire régulièrement. 

### Fonctionnalité 2 — *Tir*

Les joueurs, avec leur vaisseau, tirent dans la même direction que leur vaisseau se dirige. Cela inflige des dégâts d'une quantité définie au potentiel allié, et à l'ennemi.

### Fonctionnalité 3 — *Ennemis*

Par intermittence, des ennemis vont apparaître à chaque niveau (dans le quart supérieur de la fenêtre) ayant pour objectif de mettre des dégâts en tirant sur les cibles, étant les deux joueurs.
Lorsqu'on joue à deux, les ennemis seront plus difficiles voire plus nombreux (vie, vitesse de tir, ...)
Les ennemis peuvent avoir différents comportements : certains tirent tout droit, et ou se déplacent aléatoirement, d'autres tirer plus vite, tirer plus de fois, target 2 joueurs à la fois, ...
Leurs statistiques sont plus ou moins élevées en fonction de là où on en est.

### Fonctionnalité 4 — *Upgrades*

Au bout d'un certain temps, le jeu propose une upgrade parmi 3 sur l'écran via une interface. Elles pourront être sélectionnées avec le NumPad pour chacun à la suite. (pour faire face aux ennemis plus difficiles)

### Fonctionnalité 5 - *Tableau des scores*

En haut à gauche de l'écran, on pourra observer le score cumulé des joueurs, les upgrades qu'ils ont, ... 
Le score évoluera en fonction des kills effectués.

### Fonctionnalité 6 - *Sons lors d'événements*

Lorsqu'un ennemi sera tué, ou qu'un joueur sera tué, ou pour d'autres événements, un son spécifique sera joué. Par exemple, un bruit d'explosion lorsqu'on détruit un vaisseau, ...

### Fonctionnalité 7 - *Condition de fin de jeu*

Le jeu se finit dans le cas où tous les joueurs sont morts.
La victoire est déclarée à la fin d'un certain nombre de vagues.

## Évolutions envisagées

- Système de skins évolués avec un pattern décorator, ...
- Possibilité d'implémenter plus de joueurs
powerups, ...

