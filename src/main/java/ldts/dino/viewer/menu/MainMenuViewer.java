package ldts.dino.viewer.menu;

import ldts.dino.model.menu.MainMenu;
import ldts.dino.utils.Position;

public class MainMenuViewer extends MenuViewer<MainMenu>{

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu, new Position(8, 13));
    }

}
