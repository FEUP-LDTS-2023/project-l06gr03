package ldts.dino.viewer.game.collectables;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.collectables.Bomb;
import ldts.dino.viewer.game.ElementViewer;

public class BombViewer implements ElementViewer<Bomb> {

    @Override
    public void draw(Bomb bomb, GUI gui) {
        gui.drawImageFromFile(bomb.getPosition(), "bomb");
    }
}