package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;
import ldts.dino.utils.Position;
import ldts.dino.viewer.Colors;
import ldts.dino.viewer.Viewer;

import java.util.List;

public abstract class MenuViewer<T extends Menu> extends Viewer<T> {

    private final Integer entriesX, entriesY;

    public MenuViewer(T model, Position position) {
        super(model);
        this.entriesX = position.getX();
        this.entriesY = position.getY();
    }

    @Override
    protected void drawElements(GUI gui) {
        //draw the menu stuff
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());
        drawEntries(gui);
    }

    public void drawEntries(GUI gui) {
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                drawText(gui, new Position(entriesX, entriesY + i), ">" + getModel().getEntry(i), Colors.ORANGE.getHex());
            } else {
                drawText(gui, new Position(entriesX + 1, entriesY + i), getModel().getEntry(i), Colors.WHITE.getHex());
            }
        }
    }

    public void drawText(GUI gui, Position position, String text, String color) {
        gui.drawText(position, text, color, Colors.MENU_BACKGROUND.getHex());
    }
}