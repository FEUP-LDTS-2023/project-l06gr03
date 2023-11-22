package ldts.dino.model.menu;
import java.util.List;

public abstract class Menu {
    protected List<String> entries;
    protected int currentEntry = 0;

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getEntry(int i) {
        return this.entries.get(i);
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if(currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}