package ldts.dino.model.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoresMenu extends Menu {

    public ScoresMenu() {
        this.entries = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/scores/topscore.txt"));
            String line = reader.readLine();
            while (line != null) {
                this.entries.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}