package ldts.dino.model.game.elements.dino;

import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class NormalDino extends Dino {
    public static int HEIGHT = 30;
    public static int WIDTH = 30;
    public int normalDinoForm = 1;

    public NormalDino() {
        super(new Position(30, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

    public void changeDinoForm() {
        if(normalDinoForm == 1) {
            normalDinoForm = 2;
        } else {
            normalDinoForm = 1;
        }
    }

    public int getDinoForm() {
        return normalDinoForm;
    }

}