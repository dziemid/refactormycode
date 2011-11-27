package refactormycode.gameoflife;

import org.junit.Test;

import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class NeighborhoodTest {

    @Test
    public void shouldBe2D() throws Exception {
        // Given
        Position p = new Position(2, 2);
        Neighborhood neighborhood = new Neighborhood();

        // When
        Set<Position> neighbors = neighborhood.getNeighbors(p);

        // Then
        assertThat(neighbors.size(), is(8));
        assertThat(neighbors.containsAll(asList(
                new Position(1, 1),
                new Position(2, 1),
                new Position(3, 1),
                new Position(1, 2),
                new Position(3, 2),
                new Position(1, 3),
                new Position(2, 3),
                new Position(3, 3)
        )), is(true));
    }
}
