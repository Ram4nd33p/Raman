/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.studyopedia.a1_ramand13;

/**
 *
 * @author Raman
 */
import java.util.Scanner;

public class A1_ramand13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String id = "";
        String name = "";
        int qoh = 0;
        int rop = 0;
        double sellPrice = 0.0;

        // Prompt for Inventory Item ID
        while (true) {
            System.out.print("Enter Inventory Item ID: ");
            id = input.nextLine();
            if (isValidId(id)) {
                break;
            } else {
                System.out.println("Error: Inventory ID must be in the form ABC-1234");
            }
        }

        // Prompt for Item Name
        while (true) {
            System.out.print("Enter Item Name: ");
            name = input.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Error: You must enter an item name.");
            }
        }

        // Prompt for Quantity On Hand
        while (true) {
            System.out.print("Qty On Hand: ");
            qoh = input.nextInt();
            if (qoh >= 0) {
                break;
            } else {
                System.out.println("Error: QOH must be 0 or more.");
            }
        }

        // Prompt for Re-Order Point
        while (true) {
            System.out.print("Re-Order Point: ");
            rop = input.nextInt();
            if (rop > 0) {
                break;
            } else {
                System.out.println("Error: ROP must be greater than 0.");
            }
        }

        // Prompt for Selling Price
        while (true) {
            System.out.print("Selling Price: ");
            sellPrice = input.nextDouble();
            if (sellPrice >= 0) {
                break;
            } else {
                System.out.println("Error: Selling price must be greater than 0.");
            }
        }

        // Create an instance of the Inventory class
        Inventory item = new Inventory(id, name, qoh, rop, sellPrice);

        System.out.println(item);

        if (item.getQoh() <= item.getRop()) {
            System.out.println("You need to order more " + item.getName() + ".");
        }

        System.out.print("Enter # of units to buy: ");
        int unitsToBuy = input.nextInt();
        double totalCost = calculateTotalCost(unitsToBuy, item.getSellPrice());
        System.out.printf("Total Cost: $%.2f\n", totalCost);
    }

    public static boolean isValidId(String id) {
        return id.matches("[A-Za-z]{3}-\\d{4}");
    }

    public static double calculateTotalCost(int units, double price) {
        double subtotal = units * price;
        double hst = subtotal * 0.13;
        return subtotal + hst;
    }
}

class Inventory {
    private String id;
    private String name;
    private int qoh;
    private int rop;
    private double sellPrice;

    public Inventory() {
        id = "ABC-1234";
        name = "New Item";
        qoh = 0;
        rop = 25;
        sellPrice = 0.0;
    }

    public Inventory(String id, String name, double sellPrice) {
        this.id = id;
        this.name = name;
        this.qoh = 0;
        this.rop = 25;
        this.sellPrice = sellPrice;
    }

    public Inventory(String id, String name, int qoh, int rop, double sellPrice) {
        this.id = id;
        this.name = name;
        this.qoh = qoh;
        this.rop = rop;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (isValidId(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID format. Must be in the form ABC-1234.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        if (qoh >= 0) {
            this.qoh = qoh;
        } else {
            throw new IllegalArgumentException("QOH must be 0 or more.");
        }
    }

    public int getRop() {
        return rop;
    }

    public void setRop(int rop) {
        if (rop > 0) {
            this.rop = rop;
        } else {
            throw new IllegalArgumentException("ROP must be greater than 0.");
        }
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        if (sellPrice >= 0) {
            this.sellPrice = sellPrice;
        } else {
            throw new IllegalArgumentException("Selling price must be greater than 0.");
        }
    }

    @Override
    public String toString() {
        return id + " (" + name + "), QOH: " + qoh + " Price: $" + String.format("%.2f", sellPrice);
    }

    private boolean isValidId(String id) {
        return id.matches("[A-Za-z]{3}-\\d{4}");
    }
}

