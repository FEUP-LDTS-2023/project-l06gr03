package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.controller.game.elements.DinoController;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.collectables.Coin;
import ldts.dino.model.game.elements.collectables.Collectable;
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
        if(!getModel().isShieldActivated()) {
            for (Obstacle obstacle : getModel().getObstacles()) {
                if (obstacle.isColliding(getModel().getDino())) {
                    application.setState(new GameOverState(new GameOverMenu(), (int) getModel().getScore()));
                    return;
                }
            }
        }

        else {
            for (Obstacle obstacle : getModel().getObstacles()) {
                if (obstacle.isColliding(getModel().getDino())) {
                    if (getModel().getDino().getPosition().getX() > getModel().getObstacles().get(0).getPosition().getX()) {
                        getModel().getObstacles().remove(1);
                    }
                    else {
                        getModel().getObstacles().remove(0);
                    }
                }
            }
        }

        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()) {
            Collectable collectable = collectableIterator.next();
            if (collectable.isColliding(getModel().getDino())) {
                getModel().consumeCollectable(collectable);
                collectableIterator.remove();
            }
            //TODO melhorar e aumentar esta implementação

        }
    }
}