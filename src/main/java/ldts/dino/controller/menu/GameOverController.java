package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.dino.Dino;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.model.menu.Menu;
import ldts.dino.state.GameState;
import ldts.dino.state.MainMenuState;

public class GameOverController extends MenuController<GameOverMenu> {
    public GameOverController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void entrySelected(Application application) {
        if(getModel().isSelectedRestart()) {
            Dino.bombs.clear();
            application.setState(new GameState(new Game()));
        }
        else if(getModel().isSelectedMenu()) {
            Dino.bombs.clear();
            application.setState(new MainMenuState(new MainMenu()));
            Menu.setCurrentEntry(0);
        }
    }

    @Override
    public void backSelected(Application application) {

    }
}