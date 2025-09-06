package factory.products;

import enums.ProductCategory;
import factory.Product;

public class Clothing extends Product {
    private String color;
    private int size;

    public Clothing(int price, int quantity, String name, String sku) {
        super(price, quantity, name, sku, ProductCategory.CLOTHING);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
