package factory;

public class Food {
    protected int row, col;
    protected int points;

    public Food(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getPoints() {
        return points;
    }
}
