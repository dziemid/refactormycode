package refactormycode.gameoflife;

import java.util.*;

public class Generation {

    private final Neighborhood neighborhood;

    public Generation(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Collection<Cell> next(Collection<Cell> cells) {
        HashSet<Cell> result = new HashSet<Cell>();
        HashSet<Position> positions = new HashSet<Position>();
        HashSet<Position> positions2 = new HashSet<Position>();
        for (Cell c : cells) {
            positions.add(c.getPosition());
        }

        positions2.addAll(positions);
        for (Position p : positions) {
            positions2.addAll(neighborhood.getNeighbors(p));
        }

        for (Position p : positions2) {
            Set<Position> neighbors = neighborhood.getNeighbors(p);
            int count = 0;
            for (Position n : neighbors) {
                if (positions.contains(n)) {
                    count+=1;
                }
            }
            if ((cells.contains(new Cell(p)) && count == 2) || count == 3)
                result.add(new Cell(p));
        }

        return result;
    }

}
