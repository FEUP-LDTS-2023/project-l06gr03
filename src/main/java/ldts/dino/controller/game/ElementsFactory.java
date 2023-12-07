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
        if(game.getClock() % 50 == 0) generateObstacle();
        else if (game.getClock() % 90 == 0) generateCollectable();
        game.incrementClock();
    }
}