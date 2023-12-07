package ldts.dino.model.game.creators;

import ldts.dino.model.game.elements.collectables.*;

import java.util.Random;

public class CollectableCreator extends Creator {
    private final Random random;

    public CollectableCreator() {
        this.random = new Random();
    }

    @Override
    public Collectable create() {
        int randomObstacle = random.nextInt(4);
        switch (randomObstacle) {
            case (0):
                return new Bomb();
            case(1):
                return new Boots();
            case(2):
                return new Coin();
            case(3):
                return new Shield();
        }
        return null;
    }
}