package refactormycode.gameoflife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Neighborhood {

    public Set<Position> getNeighbors(Position p) {
        List<Position> positions = Arrays.asList(
                p(p, -1, -1), p(p, 0, -1), p(p, 1, -1),
                p(p, -1, 0),               p(p, 1, 0),
                p(p, -1, 1),  p(p, 0, 1),  p(p, 1, 1)
        );
        HashSet<Position> set = new HashSet<Position>();
        set.addAll(positions);
        return set;
    }

    private Position p(Position p, int offsetX, int offsetY) {
        return new Position(p.x + offsetX, p.y + offsetY);
    }
}
