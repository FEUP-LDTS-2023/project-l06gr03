package ldts.dino.viewer.game.obstacles;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.obstacles.Plane;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.game.ElementViewer;
import ldts.dino.viewer.game.GameViewer;

public class PlaneViewer implements ElementViewer<Plane> {

    @Override
    public void draw(Plane plane, GUI gui) {
        gui.drawImageFromFile(plane.getPosition(), "plane");
    }
}