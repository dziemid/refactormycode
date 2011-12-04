package refactormycode.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class View extends JPanel {

    protected JButton nextGenerationButton;
    Map<Position, JCheckBox> cellsToCheckBox = new HashMap<Position, JCheckBox>();

    public View() {
        this.setLayout(new BorderLayout());
        nextGenerationButton = new JButton("Next generation");
        add(nextGenerationButton, BorderLayout.NORTH);

        JPanel checkPanel = new JPanel(new GridLayout(15, 15));
        for (int y = 0; y < 15; y++)
            for (int x = 0; x < 15; x++) {
                JCheckBox checkBox = new JCheckBox();
                cellsToCheckBox.put(new Position(x, y), checkBox);
                checkPanel.add(checkBox);
            }
        add(checkPanel, BorderLayout.CENTER);
    }

    public void display(Collection<Cell> nextGeneration) {
        for (JCheckBox box : cellsToCheckBox.values()) {
            box.setSelected(false);
        }
        for (Cell c : nextGeneration) {
            JCheckBox jCheckBox = cellsToCheckBox.get(c.getPosition());
            if (jCheckBox != null)
                jCheckBox.setSelected(true);
        }
    }

    public void register(final ViewActionsListener controller) {
        nextGenerationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.moveToNextGeneration();
            }
        });
    }

    public Collection<Position> getAlifeCells() {
        HashSet<Position> cells = new HashSet<Position>();
        for (Map.Entry<Position, JCheckBox> entry : cellsToCheckBox.entrySet()) {
            if (entry.getValue().isSelected()) {
                cells.add(entry.getKey());
            }
        }

        return cells;
    }
}
