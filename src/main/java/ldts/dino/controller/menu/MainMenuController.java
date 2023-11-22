package ldts.dino.controller.menu;

import ldts.dino.Game;
import ldts.dino.model.menu.Instructions;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.model.menu.Menu;
import ldts.dino.state.InstructionsState;

public class MainMenuController extends MenuController<MainMenu> {

    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    public void entrySelected(Game game) {
        if(getModel().isSelectedStart()) System.out.println("Começa o jogo!!");
        if(getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Instructions()));
        if(getModel().isSelectedLeaderboard()) System.out.println("Leaderboard");
        if(getModel().isSelectedExit()) game.setState(null);
    }

    @Override
    public void backSelected(Game game) {
    }
}