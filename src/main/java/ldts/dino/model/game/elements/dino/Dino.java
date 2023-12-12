package ldts.dino.model.game.elements.dino;

import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class Dino extends Element {
    public int speed = 1;
    public final int MAX_SPEED = 10;
    public int gravity = 1;
    public static List<Integer> bombs = new ArrayList<>();
    public boolean hasBoots = false;


    public Dino(Position position, int width, int height) {
        super(position, width, height);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.min(speed, MAX_SPEED);
    }

    public int getGravity() {
        return gravity;
    }

    public List<Integer> getBombs() {
        return bombs;
    }

    public void setHasBoots(boolean hasBoots) {
        this.hasBoots = hasBoots;
    }

    public boolean getHasBoots() {
        return hasBoots;
    }
}