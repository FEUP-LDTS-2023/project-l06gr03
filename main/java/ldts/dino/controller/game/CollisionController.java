package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.controller.game.elements.DinoController;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.collectables.Bomb;
import ldts.dino.model.game.elements.collectables.Coin;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.collectables.Shield;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.state.GameOverState;

import java.util.Iterator;

public class CollisionController extends Controller<Game> {

    protected CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if(getModel().getGround().isColliding(getModel().getDino())) {
            getModel().getDino().getPosition().setY(getModel().getGround().getPosition().getY() - getModel().getDino().getHeight());
        }
        for(Obstacle obstacle: getModel().getObstacles()) {
            if (obstacle.isColliding(getModel().getDino())) {
                application.setState(new GameOverState(new GameOverMenu()));
                return;
            }
        }

        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()) {
            Collectable collectable = collectableIterator.next();
            if (collectable.isColliding(getModel().getDino())) {
                collectableIterator.remove();
                if (collectable.getClass().equals(Coin.class)) {
                    getModel().setScore(getModel().getScore() + 200);
                } else if (collectable.getClass().equals(Bomb.class)) {
                    getModel().getObstacles().remove(0);
                }
            }
            //TODO melhorar e aumentar esta implementação

        }
    }
}