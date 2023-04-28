package org.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store(String inventoryFile) {
        products = new ArrayList<>();
        loadInventory(inventoryFile);
    }

    private void loadInventory(String inventoryFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                products.add(new Product(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
