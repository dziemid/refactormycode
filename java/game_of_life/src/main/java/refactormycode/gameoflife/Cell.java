package refactormycode.gameoflife;

public class Cell {

    private final Position position;

    public Cell(int x, int y) {
       this(new Position(x, y));
    }

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (position != null ? !position.equals(cell.position) : cell.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
