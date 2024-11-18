// public class KhaidaiBistroMenu {
//     public static void main(String[] args) {
//         // Basic items
//         Item burger = new Item("Burger", 300);
//         Item fries = new Item("Fries", 100);
//         Item wedges = new Item("Wedges", 150);
//         Item shawarma = new Item("Shawarma", 200);
//         Item drink = new Item("Drink", 25);

//         // Existing combos
//         Combo combo1 = new Combo("Combo1");
//         combo1.addItem(burger);
//         combo1.addItem(fries);
//         combo1.addItem(drink);
//         combo1.applyDiscount(10);

//         Combo combo2 = new Combo("Combo2");
//         combo2.addItem(shawarma);
//         combo2.addItem(drink);

//         // Display existing menu
//         System.out.println("Menu:");
//         burger.display();
//         fries.display();
//         wedges.display();
//         shawarma.display();
//         drink.display();
//         combo1.display();
//         combo2.display();

//         // Create a custom combo
//         Combo superCombo = new Combo("SuperCombo");
//         superCombo.addItem(combo2);
//         superCombo.addItem(burger);
//         wedges.setFree();
//         superCombo.addItem(wedges);
//         superCombo.applyDiscount(5);

//         // Display custom combo
//         System.out.println("\nYour combo:");
//         superCombo.display();
//     }
// }

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhaidaiBistroMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Basic items
        Item burger = new Item("Burger", 300);
        Item fries = new Item("Fries", 100);
        Item wedges = new Item("Wedges", 150);
        Item shawarma = new Item("Shawarma", 200);
        Item drink = new Item("Drink", 25);

        // Existing combos with fixed prices
        Combo combo1 = new Combo("Combo1", 400, true); // Fixed price of 400
        combo1.addItem(burger);
        combo1.addItem(fries);
        combo1.addItem(drink);

        Combo combo2 = new Combo("Combo2", 215, true); // Fixed price of 215
        combo2.addItem(shawarma);
        combo2.addItem(drink);

        List<MenuItem> menu = new ArrayList<>();
        menu.add(burger);
        menu.add(fries);
        menu.add(wedges);
        menu.add(shawarma);
        menu.add(drink);
        menu.add(combo1);
        menu.add(combo2);

        while (true) {
            System.out.println("\nPress 1 to create a combo, 2 to view menu, and 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter the name of the combo: ");
                String comboName = scanner.nextLine();
                Combo customCombo = new Combo(comboName, 0, false); // No fixed price for custom combos

                while (true) {
                    System.out.println("\nAvailable commands:");
                    System.out.println("Add [item]");
                    System.out.println("Remove [item]");
                    System.out.println("Free [item]");
                    System.out.println("Discount [percentage]");
                    System.out.println("Done");

                    String command = scanner.nextLine();
                    String[] parts = command.split(" ", 2);

                    if (parts[0].equalsIgnoreCase("Add")) {
                        String itemName = parts[1];
                        MenuItem itemToAdd = findItemByName(menu, itemName);
                        if (itemToAdd != null) {
                            customCombo.addItem(itemToAdd);
                            System.out.println(itemName + " added to " + comboName);
                        } else {
                            System.out.println("Item not found.");
                        }
                    } else if (parts[0].equalsIgnoreCase("Remove")) {
                        String itemName = parts[1];
                        MenuItem itemToRemove = findItemByName(menu, itemName);
                        if (itemToRemove != null) {
                            customCombo.removeItem(itemToRemove);
                            System.out.println(itemName + " removed from " + comboName);
                        } else {
                            System.out.println("Item not found.");
                        }
                    } else if (parts[0].equalsIgnoreCase("Free")) {
                        String itemName = parts[1];
                        MenuItem itemToFree = findItemByName(menu, itemName);
                        if (itemToFree != null) {
                            itemToFree.setFree();
                            customCombo.addItem(itemToFree);
                            System.out.println(itemName + " added as Free to " + comboName);
                        } else {
                            System.out.println("Item not found.");
                        }
                    } else if (parts[0].equalsIgnoreCase("Discount")) {
                        int discount = Integer.parseInt(parts[1]);
                        customCombo.applyDiscount(discount);
                        System.out.println("Discount of " + discount + "% applied to " + comboName);
                    } else if (parts[0].equalsIgnoreCase("Done")) {
                        menu.add(customCombo);
                        System.out.println(comboName + " created!");
                        customCombo.display();
                        break;
                    } else {
                        System.out.println("Invalid command.");
                    }
                }
            } else if (choice == 2) {
                System.out.println("\nMenu:");
                for (MenuItem item : menu) {
                    item.display();
                }
            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static MenuItem findItemByName(List<MenuItem> menu, String name) {
        for (MenuItem item : menu) {
            if (item.name.equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}