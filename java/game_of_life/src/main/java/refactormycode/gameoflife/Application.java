package refactormycode.gameoflife;

import javax.swing.*;

public class Application {

    private static void createAndShowGUI() {
        View view = new View();
        Generation generation = new Generation(new Neighborhood());

        GameOfLifeController controller = new GameOfLifeController(view, generation);
        view.register(controller);

        JFrame frame = new JFrame("Game of life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
