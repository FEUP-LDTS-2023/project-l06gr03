package ldts.dino.model.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu{
    public GameOverMenu() {
        this.entries = Arrays.asList("Restart", "Menu");
    }
    public boolean isSelectedRestart() { return isSelected(0); }
    public boolean isSelectedMenu() { return isSelected(1); }
}