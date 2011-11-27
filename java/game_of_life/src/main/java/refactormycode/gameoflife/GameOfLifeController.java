package refactormycode.gameoflife;

import java.util.Collection;

public class GameOfLifeController implements ViewActionsListener {

    private final View view;
    private final Generation generation;

    public GameOfLifeController(View view, Generation generation) {
        this.view = view;
        this.generation = generation;
    }

    public void moveToNextGeneration() {
        Collection<Cell> alifeCells = view.getAlifeCells();
        Collection<Cell> nextCells = generation.next(alifeCells);
        view.display(nextCells);
    }

}
