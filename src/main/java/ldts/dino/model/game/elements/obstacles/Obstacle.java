package ldts.dino.model.game.elements.obstacles;

import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Position;

public abstract class Obstacle extends Element {
    private final int speed = 5;
    public Obstacle(Position position, int width, int height) {
        super(position, width, height);
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        this.getPosition().setX(this.getPosition().getX() - getSpeed());
    }
}