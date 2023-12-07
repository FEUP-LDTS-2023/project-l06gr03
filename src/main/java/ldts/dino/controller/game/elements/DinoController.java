package ldts.dino.controller.game.elements;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.utils.Position;

public class DinoController extends Controller<Game> {
    private final Dino dino;

    public DinoController(Game model) {
        super(model);
        this.dino = model.getDino();
    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        dinoForm();
        updatePosition();
        if(action == GUI.ACTION.JUMP) {
            jump();
        }
    }

    private void dinoForm() {
        if(getModel().getClock() % 5 == 0) {
            getModel().getDino().changeDinoForm();
        }
    }

    private void updatePosition() {
        Position position = dino.getPosition();
        position.setY(position.getY() + dino.getSpeed());
        dino.setSpeed(dino.getSpeed() + dino.getGravity());
        // System.out.println(position);
    }

    private void jump() {
        if(dino.getPosition().getY() > Ground.HEIGHT - dino.getHeight()) {
            dino.setSpeed(-10);
        }
    }
}