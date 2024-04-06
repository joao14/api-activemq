package activemq.backend.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int stock;
    private float price;

    public Product() {
    }

    public Product(String name, int stock, float price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
