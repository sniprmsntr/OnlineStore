package org.yearup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("Inventory.csv");
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayHomeScreen();
            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    showProducts(store, cart, scanner);
                    break;
                case "2":
                    showCart(cart, scanner);
                    break;
                case "3":
                    System.out.println("Thanks for shopping!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("1. Show Products");
        System.out.println("2. Show Cart");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void showProducts(Store store, Cart cart, Scanner scanner) {
        System.out.println("\nProducts:");
        for (Product product : store.getProducts()) {
            System.out.printf("%s | %s | $%.2f%n", product.getId(), product.getName(), product.getPrice());
        }

        System.out.print("\nEnter product ID to add to cart, or 'X' to go back: ");
        String input = scanner.nextLine().trim();

        if (!input.equalsIgnoreCase("x")) {
            Product selectedProduct = store.getProducts().stream()
                    .filter(p -> p.getId().equalsIgnoreCase(input))
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                cart.addItem(selectedProduct);
                System.out.println("Product added to cart.");
            } else {
                System.out.println("Invalid product ID.");
            }
        }
    }

    private static void showCart(Cart cart, Scanner scanner) {
        System.out.println("\nCart:");

        for (Product item : cart.getItems()) {
            System.out.printf("%s | %s | $%.2f%n", item.getId(), item.getName(), item.getPrice());
        }

        System.out.printf("\nTotal: $%.2f%n", cart.getTotal());

        System.out.print("\nEnter 'C' to check out or 'X' to go back: ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("c")) {
            checkOut(cart, scanner);
        }
    }

    private static void checkOut(Cart cart, Scanner scanner) {
        System.out.printf("\nTotal amount: $%.2f%n", cart.getTotal());
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();
        scanner.nextLine();

        if (payment >= cart.getTotal()) {
            double change = payment - cart.getTotal();
            System.out.printf("Change: $%.2f%n", change);

            System.out.println("\nItems sold:");
            for (Product item : cart.getItems()) {
                System.out.printf("%s | %s | $%.2f%n", item.getId(), item.getName(), item.getPrice());
            }

            cart.clear();
        } else {
            System.out.println("Insufficient payment. Money returned.");
        }
    }
}
