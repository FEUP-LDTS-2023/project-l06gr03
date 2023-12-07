package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.collectables.*;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.game.elements.obstacles.Plane;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.game.collectables.BombViewer;
import ldts.dino.viewer.game.collectables.BootsViewer;
import ldts.dino.viewer.game.collectables.CoinViewer;
import ldts.dino.viewer.game.collectables.ShieldViewer;
import ldts.dino.viewer.game.obstacles.BuildingViewer;
import ldts.dino.viewer.game.obstacles.CityViewer;
import ldts.dino.viewer.game.obstacles.PlaneViewer;

import java.util.List;

public class GameViewer extends Viewer<Game> {

    public GameViewer(Game model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.BLUE.getHex());
        drawElement(gui, getModel().getGround(), new GroundViewer());
        drawElement(gui, getModel().getDino(), new DinoViewer());
        drawObstacles(gui, getModel().getObstacles());
        drawCollectables(gui, getModel().getCollectables());
    }

    private void drawObstacles(GUI gui, List<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if(obstacle.getClass() == City.class) {
                new CityViewer().draw((City) obstacle, gui);
            } else {
                new PlaneViewer().draw((Plane) obstacle, gui);
            }
        }
    }

    private void drawCollectables(GUI gui, List<Collectable> collectables) {
        for (Collectable collectable : collectables) {
            if (collectable.getClass().equals(Bomb.class)) {
                new BombViewer().draw((Bomb) collectable, gui);
            } else if (collectable.getClass().equals(Boots.class)) {
                new BootsViewer().draw((Boots) collectable, gui);
            } else if (collectable.getClass().equals(Coin.class)) {
                new CoinViewer().draw((Coin) collectable, gui);
            } else if (collectable.getClass().equals(Shield.class)) {
                new ShieldViewer().draw((Shield) collectable, gui);
            } else {
                System.out.println("error");
            }
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}