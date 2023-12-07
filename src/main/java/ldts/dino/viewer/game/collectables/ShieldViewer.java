package ldts.dino.viewer.game.collectables;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.collectables.Shield;
import ldts.dino.viewer.game.ElementViewer;

public class ShieldViewer implements ElementViewer<Shield> {
    @Override
    public void draw(Shield shield, GUI gui) {
        gui.drawImageFromFile(shield.getPosition(), "shield");
    }
}