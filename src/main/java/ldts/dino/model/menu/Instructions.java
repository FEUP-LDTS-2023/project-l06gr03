package ldts.dino.model.menu;

import java.util.ArrayList;
import java.util.List;

public class Instructions extends Menu {

    private static final List<String> instructions = new ArrayList<>();

    public Instructions() {
        instructions.add("The goal of the game is to");
        instructions.add("get as many points as you can");
        instructions.add("without colliding with the");
        instructions.add("cactus nor the birds.");
        instructions.add("\n");
        instructions.add("You can jump by pressing");
        instructions.add("ARROW UP and squat with");
        instructions.add("ARROW DOWN.");
        instructions.add("\n");
        instructions.add("You can collect points by");
        instructions.add("touching them with Dino.");
    }

    public boolean isSelectedBack() { return isSelected(5); }
}