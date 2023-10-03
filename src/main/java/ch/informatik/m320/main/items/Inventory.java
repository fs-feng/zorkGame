package ch.informatik.m320.main.items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory; //inventory list


    //constructor
    public Inventory() {
        inventory = new ArrayList<>();

    }


    public Item removeItem(int index) {
        Item item = inventory.get(index);
        inventory.remove(index);

        return item;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }


    //getter
    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
