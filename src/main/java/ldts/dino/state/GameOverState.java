package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.GameOverController;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.GameOverViewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

public class GameOverState extends State<GameOverMenu> {

    public GameOverState(GameOverMenu model, int score) {
        super(model);
        saveHighScore(score);
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }

    private void saveHighScore(int score) {
        String sep = " - ";
        List<Integer> scores = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/scores/topscore.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(sep);
                String s = parts[1];
                scores.add(Integer.valueOf(s));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scores.add(score);
        sort(scores);
        reverse(scores);

        if (scores.size() > 3) {
            scores.remove(3);
        }

        try (FileWriter writer = new FileWriter("src/main/resources/scores/topscore.txt")) {
            for (int i = 0; i < scores.size(); i++) {
                writer.write((i + 1) + sep + scores.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}