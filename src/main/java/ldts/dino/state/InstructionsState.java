package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.InstructionsController;
import ldts.dino.model.menu.Instructions;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions> {

    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }
}
