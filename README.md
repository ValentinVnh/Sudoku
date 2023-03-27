# Sudoku MVC
***

### 3- Quel(s) principe(s) SOLID est/sont violié(s) dans cette solution ?

- Single Responsability Principle
  - Elle ne respecte pas le principe de responsabilité unique, elle s'occupe de différentes tâches
- Open/Closed Principle
  - Elle ne respecte pas le principe d'ouverture/fermeture, une commande est ajoutée mais peut touchée à l'existant.
- Dependency Inversion Principle
  - Elle ne respecte pas le principe d'inversion de dépendance, l'invocateur ne manipule aucune interface.

***

### 4 - Dans la classe Sudoku, quels éléments pourraient appartenir à la partie modèle et quels éléments pourraient appartenir à la partie vue ?

Les éléments qui pourraient appartenir à la partie modèle sont :
- getValueAt()
- isValueValid()
- setValueAt()
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

- Pour toute les fonctions qui font partie des données et de la logique métier de l’application. Les mettre dans une classe ModelSudoku dans un package Model.
- Pour toute les fonctions qui représente l’interface utilisateur de l’application. Il faut les mettre dans une classe VueSudoku dans un package vue.

### 2- Comment utiliser la pattern Observateur pour faire en sorte qu’une mise à jour d’une cellule du sudoku déclenche une action sur la vue ? En l’occurrence, cette action sera simplement d’afficher les coordonnées mise à jour (avec la nouvelle valeur) puis d’afficher la grille.

Pour utiliser la pattern Observateur et faire en sorte qu'une mise à jour d'une cellule du Sudoku déclenche une action sur la vue, il faut créer une classe ObserverSudoku qui implémente l'interface Observateur.

