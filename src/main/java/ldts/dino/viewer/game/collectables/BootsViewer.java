package ldts.dino.viewer.game.collectables;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.collectables.Boots;
import ldts.dino.viewer.game.ElementViewer;

public class BootsViewer implements ElementViewer<Boots> {
    @Override
    public void draw(Boots boots, GUI gui) {
        gui.drawImageFromFile(boots.getPosition(), "boots");
    }
}