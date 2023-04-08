# Sudoku MVC
***

### 3- Quel(s) principe(s) SOLID est/sont violié(s) dans cette solution ?

- Single Responsability Principle
  - Elle ne respecte pas le principe de responsabilité unique, elle s'occupe de différentes tâches
    - lecture du fichier, mises à jour du plateau, affichage du plateau, validation des valeurs, demande coordonnée à l'utilisateur 
- Open/Closed Principle
  - Elle ne respecte pas le principe d'ouverture/fermeture, une commande est ajoutée, mais peut toucher à l'existant.
- Dependency Inversion Principle
  - Elle ne respecte pas le principe d'inversion de dépendance, l'invocateur ne manipule aucune interface.
    - Sudoku dépend directement de plusieurs classes concrètes

***

### 4 - Dans la classe Sudoku, quels éléments pourraient appartenir à la partie modèle et quels éléments pourraient appartenir à la partie vue ?

Les éléments qui pourraient appartenir à la partie modèle sont :
- getValueAt()
- setValueAt()
- isValueValid()
- getBoardSize()
- getBlockSize()
- isGameFinished()

Les éléments qui pourraient appartenir à la partie vue sont :
- Sudoku()
- display()
- update()
- displayWelcomeMessage()
- askUserForCoords()
- askUserForValue()
- displayVictoryMessage()
***

# Solution MVC et autres patterns
## Observateur

### 1- Comment séparer la classe Sudoku en une entité vue et une entité modèle ?

Pour séparer la classe Sudoku en une entité vue et une entité modèle, il faut :

- Pour toutes les fonctions qui font partie des données et de la logique métier de l’application. Les mettre dans une classe ModelSudoku dans un package Model.
- Pour toutes les fonctions qui représentent l’interface utilisateur de l’application. Il faut les mettre dans une classe VueSudoku dans un package vue.

### 2- Comment utiliser la pattern Observer pour faire en sorte qu’une mise à jour d’une cellule du sudoku déclenche une action sur la vue ?

Pour utiliser la pattern Observer et faire en sorte qu'une mise à jour d'une cellule du Sudoku déclenche une action sur la vue, il faut créer une classe ObserverSudoku qui implémente l'interface Observateur qui contiendra une méthode update.
Nous, allons également ajouter une méthode addObserver() et notifyObserver() à la classe SudokuModel.

## Strategie

### 1 - Compte-tenu de cette information, en quoi votre conception actuelle n’est pas évolutive ?

La conception actuelle n'est pas évolutive puisque si l'on veut modifier l'algorithme, il faut programmer une nouvelle classe et modifier le fonctionnement dans le code, notamment celui du ControllerModel.

### 2 - Comment utiliser la pattern Strategie pour y remédier ?

Pour utiliser le pattern Strategie afin de remédier à une solution non évolutive, nous allons récupérer l'algorithme permettant la résolution et implémenter plusieurs classes différentes pour les différents types de résolution et une interface Strategy qui définit une méthode execute().
Ce pattern permettra à l'avenir de rajouter d'autres stratégies qui seront contenues dans de nouvelles classes, mais ne modifie pas le code existant.

## Commande

### 1 - Comment utiliser la pattern Commande afin de mettre en place ce système ?

Le pattern Commande, nous permet de mettre en place un système avec lequel les actions demandées par l'utilisateur sont encapsulées dans des objets de command distincts et qui seront elle-même exécutés par demande du client. 
