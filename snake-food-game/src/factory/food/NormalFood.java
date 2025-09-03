package factory.food;

import factory.Food;

public class NormalFood extends Food {
    public NormalFood(int row, int col) {
        super(row, col);
        this.points = 1;
    }
}
