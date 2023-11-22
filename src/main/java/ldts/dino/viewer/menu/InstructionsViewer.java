package ldts.dino.viewer.menu;

import ldts.dino.model.menu.Instructions;
import ldts.dino.utils.Position;

public class InstructionsViewer extends MenuViewer<Instructions> {

    public InstructionsViewer(Instructions model) {
        super(model, new Position(2, 7));
    }

}
