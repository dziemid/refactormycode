package refactormycode.gameoflife;

import org.junit.Test;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameOfLifeControllerTest {

    @Test
    public void shouldUseGenerationToTransformCellsAndThenDisplayItUsingView() throws Exception {
        // Given
        View view = mock(View.class);
        Generation generation = mock(Generation.class);

        Set cells = mock(Set.class);
        Set nextGeneration = mock(Set.class);

        when(view.getAlifeCells()).thenReturn(cells);
        when(generation.next(cells)).thenReturn(nextGeneration);

        GameOfLifeController controller = new GameOfLifeController(view, generation);

        // When
        controller.moveToNextGeneration();

        // Then
        verify(view).display(nextGeneration);
    }
}
