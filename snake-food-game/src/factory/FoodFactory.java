package factory;

import factory.food.BonusFood;
import factory.food.NormalFood;

public class FoodFactory {

    public static Food createFood(int position[], String type) {
        if(type.equalsIgnoreCase("bonus")) {
            return new BonusFood(position[0], position[1]);
        }

        return new NormalFood(position[0], position[1]);
    }
}
