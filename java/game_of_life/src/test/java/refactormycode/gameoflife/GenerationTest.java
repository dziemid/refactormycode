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
        Cell cell = new Cell(0,0);
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Cell> nextGeneration = generation.next(Arrays.asList(cell));

        // Then
        assertThat(nextGeneration.contains(cell), is(false));
    }

    @Test
    public void happyCellShouldSurvive() throws Exception {
        List<Cell> cells = Arrays.asList(new Cell(0, 0), new Cell(0,1), new Cell(0,2));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Cell> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.contains(new Cell(0,1)), is(true));
    }

    @Test
    public void overcrowdedCellShouldDie() throws Exception {
        List<Cell> cells = Arrays.asList(new Cell(1, 1), new Cell(-1, 1), new Cell(0, 0), new Cell(0,1), new Cell(0,2));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Cell> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.contains(new Cell(0,1)), is(false));
    }


    @Test
    public void threeCellsCreateLife() throws Exception {
        List<Cell> cells = Arrays.asList(new Cell(0, 0), new Cell(0,1), new Cell(1,0));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Cell> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.contains(new Cell(1,1)), is(true));
    }

    @Test
    public void sqareIsStable() throws Exception {
        List<Cell> cells = Arrays.asList(new Cell(0, 0), new Cell(0,1), new Cell(1,0), new Cell(1,1));
        Generation generation = new Generation(new Neighborhood());

        // When
        Collection<Cell> nextGeneration = generation.next(cells);

        // Then
        assertThat(nextGeneration.size() , is(4));
    }
}
