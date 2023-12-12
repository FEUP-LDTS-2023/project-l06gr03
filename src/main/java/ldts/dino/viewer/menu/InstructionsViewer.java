package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;

public class InstructionsViewer extends MenuViewer<InstructionsMenu> {

    public InstructionsViewer(InstructionsMenu instructionsMenu) {
        super(instructionsMenu, new Position(10, 10));
    }

    @Override
    protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY) {
        gui.drawImageFromFile(new Position(0, 0), "instructions");
    }
}