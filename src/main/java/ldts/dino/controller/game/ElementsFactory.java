package ldts.dino.controller.game;


import ldts.dino.model.game.Game;
import ldts.dino.model.game.creators.CollectableCreator;
import ldts.dino.model.game.creators.ObstacleCreator;

public class ElementsFactory {
    private final Game game;
    private final ObstacleCreator obstacleCreator;
    private final CollectableCreator collectableCreator;

    public ElementsFactory(Game game) {
        this.game = game;
        this.obstacleCreator = new ObstacleCreator();
        this.collectableCreator = new CollectableCreator();
    }

    public void generateObstacle() {
        game.addObstacle(obstacleCreator.create());
    }

    public void generateCollectable() {
        game.addCollectable(collectableCreator.create());
    }

    public void step() {
        if (game.getScore() <= 250) {
            if (game.getClock() % 50 == 0) generateObstacle();
            else if (game.getClock() % 90 == 0) generateCollectable();
            game.updateClock();
        }
        else if (game.getScore() <= 500) {
            if (game.getClock() % 45 == 0) generateObstacle();
            else if (game.getClock() % 90 == 0) generateCollectable();
            game.updateClock();
        }
        else if (game.getScore() <= 750) {
            if (game.getClock() % 40 == 0) generateObstacle();
            else if (game.getClock() % 80 == 0) generateCollectable();
            game.updateClock();
        }
        else if (game.getScore() <= 1000) {
            if (game.getClock() % 35 == 0) generateObstacle();
            else if (game.getClock() % 70 == 0) generateCollectable();
            game.updateClock();
        }
        else if (game.getScore() <= 1250) {
            if (game.getClock() % 30 == 0) generateObstacle();
            else if (game.getClock() % 60 == 0) generateCollectable();
            game.updateClock();
        }
        else {
            if (game.getClock() % 30 == 0) generateObstacle();
            else if (game.getClock() % 50 == 0) generateCollectable();
            game.updateClock();
        }
    }
}