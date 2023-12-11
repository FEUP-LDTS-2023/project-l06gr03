package ldts.dino.model.game.elements.collectables;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

import java.util.Random;

public class Bomb extends Collectable{
    public Position position;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private final Random random;

    public Bomb() {
        super(new Position(LanternaGUI.WIDTH, 50), WIDTH, HEIGHT);
        this.random = new Random();
        int y = random.nextInt(50, Ground.HEIGHT-HEIGHT);
        this.getPosition().setY(y);
    }

    @Override
    public void consume(Game game) {

    }
}