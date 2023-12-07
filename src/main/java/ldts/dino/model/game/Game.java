package ldts.dino.model.game;

import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Dino dino;
    private final Ground ground;
    private final List<Obstacle> obstaclesList;
    private final List<Collectable> collectablesList;

    private int clock;

    public Game() {
        this.dino = new Dino();
        this.ground = new Ground();
        this.obstaclesList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();
        this.clock = 0;
    }

    public Dino getDino() {
        return dino;
    }

    public Ground getGround() {
        return ground;
    }

    public int getClock() {
        return clock;
    }

    public void incrementClock() {
        clock++;
    }

    public List<Obstacle> getObstacles() {
        return obstaclesList;
    }

    public List<Collectable> getCollectables() {
        return collectablesList;
    }

    public void addObstacle(Obstacle obstacle) {
        obstaclesList.add(obstacle);
    }

    public void addCollectable(Collectable collectable) {
        collectablesList.add(collectable);
    }
}