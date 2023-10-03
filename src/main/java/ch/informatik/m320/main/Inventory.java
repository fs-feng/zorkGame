package ch.informatik.m320.main;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Item> Inventory = new ArrayList<Item>();
    public final int inventorySize;
    public final int maxPlayerWeight;

    public Inventory(int inventorySize, int maxPlayerWeight) {
        this.inventorySize = inventorySize;
        this.maxPlayerWeight = maxPlayerWeight;
    }

    public void addItem(Item item) {

    }
}
