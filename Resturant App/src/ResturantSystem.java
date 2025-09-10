import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResturantSystem {
    private Map<String, Double> menu;
    private ArrayList<String> order;
    private double total;

    public ResturantSystem() {
        // Initialize menu with items and prices
        menu = new HashMap<>();
        menu.put("Burger", 8.99);
        menu.put("Pizza", 12.99);
        menu.put("Salad", 6.99);
        menu.put("Soda", 1.99);
        order = new ArrayList<>();
        total = 0.0;
    }

    // Display the menu
    public void displayMenu() {
        System.out.println("\n=== Restaurant Menu ===");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.printf("%s: $%.2f\n", item.getKey(), item.getValue());
        }
    }

    // Add item to order
    public void addToOrder(String item) {
        if (menu.containsKey(item)) {
            order.add(item);
            total += menu.get(item);
            System.out.println(item + " added to your order.");
        } else {
            System.out.println("Sorry, " + item + " is not on the menu.");
        }
    }

    // Display the current order and total
    public void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
        } else {
            System.out.println("\n=== Your Order ===");
            for (String item : order) {
                System.out.printf("%s: $%.2f\n", item, menu.get(item));
            }
            System.out.printf("Total: $%.2f\n", total);
        }
    }

    // 👇 main method must be INSIDE the class
    public static void main(String[] args) {
        ResturantSystem restaurant = new ResturantSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Restaurant Ordering System ===");
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. View Order");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    restaurant.displayMenu();
                    break;
                case 2:
                    restaurant.displayMenu();
                    System.out.print("Enter item name to order (e.g., Burger, Pizza): ");
                    String item = scanner.nextLine();
                    restaurant.addToOrder(item);
                    break;
                case 3:
                    restaurant.viewOrder();
                    break;
                case 4:
                    restaurant.viewOrder();
                    System.out.println("Thank you for dining with us! Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }
}
