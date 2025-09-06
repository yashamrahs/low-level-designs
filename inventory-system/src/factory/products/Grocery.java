package factory.products;

import enums.ProductCategory;
import factory.Product;

public class Electronics extends Product {
    private String color;
    private int size;

    public Electronics(int price, int quantity, String name, String sku) {
        super(price, quantity, name, sku, ProductCategory.ELECTRONICS);
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
