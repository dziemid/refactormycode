package refactormycode.gameoflife;

import java.util.*;

public class Generation {

    private final Neighborhood neighborhood;

    public Generation(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Collection<Cell> next(Collection<Cell> cells) {
        HashSet<Position> positionsOfLivingCells = new HashSet<Position>();
        for (Cell c : cells) {
            positionsOfLivingCells.add(c.getPosition());
        }

        HashSet<Position> positionsToConsider = new HashSet<Position>();
        positionsToConsider.addAll(positionsOfLivingCells);
        for (Position p : positionsOfLivingCells) {
            positionsToConsider.addAll(neighborhood.getNeighbors(p));
        }

        HashSet<Cell> nextGeneration = new HashSet<Cell>();
        for (Position p : positionsToConsider) {
            Set<Position> neighbors = neighborhood.getNeighbors(p);
            int count = 0;
            for (Position n : neighbors) {
                if (positionsOfLivingCells.contains(n)) {
                    count+=1;
                }
            }
            if ((positionsOfLivingCells.contains(p) && count == 2) || count == 3)
                nextGeneration.add(new Cell(p));
        }

        return nextGeneration;
    }

}
