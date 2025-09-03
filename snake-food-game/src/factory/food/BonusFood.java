package factory.food;

import factory.Food;

public class BonusFood extends Food {
    public BonusFood(int row, int col) {
        super(row, col);
        this.points = 3;
    }
}
