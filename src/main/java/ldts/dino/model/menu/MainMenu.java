package ldts.dino.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {
    public MainMenu() {
        this.entries = Arrays.asList("Start", "Instructions", "Leaderboard", "Exit");
    }

    public boolean isSelectedStart() { return isSelected(0); }
    public boolean isSelectedInstructions() {
        return isSelected(1);
    }
    public boolean isSelectedLeaderboard() {
        return isSelected(2);
    }
    public boolean isSelectedExit() { return isSelected(3); }
}