package ch.informatik.m320.main;

public class Player {
    private Inventory playerInventory;

    public Player(int inventorySize, int maxPlayerWeight) {
        this.playerInventory = new Inventory(inventorySize, maxPlayerWeight);
    }

    public Inventory getInventory() {
        return this.playerInventory;
    }
}
