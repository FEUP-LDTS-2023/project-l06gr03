package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.controller.game.elements.DinoController;
import ldts.dino.controller.game.elements.MotionController;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;

public class GameController extends Controller<Game> {
    private final ElementsFactory elementsFactory;
    private final MotionController motionController;
    private final DinoController dinoController;
    private final CollisionController collisionController;

    public GameController(Game model) {
        super(model);
        this.elementsFactory = new ElementsFactory(model);
        this.dinoController = new DinoController(model);
        this.motionController = new MotionController(model);
        this.collisionController = new CollisionController(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        switch (action) {
            case QUIT:
                application.setState(null);
                break;
            case BOMB:
                if (!getModel().getDino().getBombs().isEmpty() && !getModel().getObstacles().isEmpty()) {
                    getModel().getDino().getBombs().remove(0);
                    if (getModel().getDino().getPosition().getX() > getModel().getObstacles().get(0).getPosition().getX()) {
                        getModel().getObstacles().remove(1);
                    }
                    else {
                        getModel().getObstacles().remove(0);
                    }
                }
        }
        getModel().setScore((float) (getModel().getScore() + 0.5));
        elementsFactory.step();
        motionController.step(application, action, time);
        dinoController.step(application, action, time);
        collisionController.step(application, action, time);
    }
}