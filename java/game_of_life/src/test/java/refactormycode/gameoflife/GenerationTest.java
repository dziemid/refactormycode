package refactormycode.gameoflife;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GenerationTest {

    @Test
    public void lonelyCellDies() throws Exception {
        // Given
        Position position = new Position(0,0);
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Position> nextGeneration = generation.next(Arrays.asList(position));

        // Then
        assertThat(nextGeneration.contains(position), is(false));
    }

    @Test
    public void happyCellShouldSurvive() throws Exception {
        List<Position> positionsOfLivingCells = Arrays.asList(new Position(0, 0), new Position(0,1), new Position(0,2));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Position> nextGeneration = generation.next(positionsOfLivingCells);

        // Then
        assertThat(nextGeneration.contains(new Position(0,1)), is(true));
    }

    @Test
    public void overcrowdedCellShouldDie() throws Exception {
        List<Position> positions = Arrays.asList(new Position(1, 1), new Position(-1, 1), new Position(0, 0), new Position(0,1), new Position(0,2));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Position> nextGeneration = generation.next(positions);

        // Then
        assertThat(nextGeneration.contains(new Position(0,1)), is(false));
    }


    @Test
    public void threeCellsCreateLife() throws Exception {
        List<Position> cells = Arrays.asList(new Position(0, 0), new Position(0,1), new Position(1,0));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Position> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.contains(new Position(1,1)), is(true));
    }

    @Test
    public void sqareIsStable() throws Exception {
        List<Position> cells = Arrays.asList(new Position(0, 0), new Position(0,1), new Position(1,0), new Position(1,1));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Position> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.size() , is(4));
    }
}
