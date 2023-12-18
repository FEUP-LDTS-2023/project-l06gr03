package ldts.dino.model.game.elements.dino;

import ldts.dino.utils.Position;

public class CrouchDino extends Dino {
    public static int HEIGHT = 18;
    public static int WIDTH = 40;
    public int crouchDinoForm = 1;

    public CrouchDino(Position position) {
        super(position, WIDTH, HEIGHT);
    }

    public void changeDinoForm() {
        if(crouchDinoForm == 1) {
            crouchDinoForm = 2;
        } else {
            crouchDinoForm = 1;
        }
    }

    public int getCrouchDinoForm() {
        return crouchDinoForm;
    }

}