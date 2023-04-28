package org.yearup;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    private double total;

    public Cart() {
        items = new ArrayList<>();
        total = 0.0;
    }

    public void addItem(Product product) {
        items.add(product);
        total += product.getPrice();
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void clear() {
        items.clear();
        total = 0.0;
    }
}
