package ldts.dino.viewer.game.collectables;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.collectables.Coin;
import ldts.dino.viewer.game.ElementViewer;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawImageFromFile(coin.getPosition(), "coin");

    }
}