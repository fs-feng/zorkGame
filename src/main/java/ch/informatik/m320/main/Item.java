package ch.informatik.m320.main;

public abstract class Item {
    private String itemName;
    private int itemWeight;

    public Item(String itemName, int itemWeight){
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }

    public abstract void useItem();
}
