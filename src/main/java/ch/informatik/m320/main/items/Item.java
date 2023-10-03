package ch.informatik.m320.main.items;

public class Item {
    private String itemName;
    private int itemWeight;

    public Item(String itemName, int itemWeight){
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }

    public void useItem(){
        //item use logic here..
    }
}
