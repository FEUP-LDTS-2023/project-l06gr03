package ldts.dino.controller.menu;

import ldts.dino.Game;
import ldts.dino.model.menu.Instructions;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.state.MainMenuState;

public class InstructionsController extends MenuController<Instructions> {

    public InstructionsController(Instructions model) {
        super(model);
    }

    @Override
    public void entrySelected(Game game) {
    }

    @Override
    public void backSelected(Game game) {
        if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
    }
}
