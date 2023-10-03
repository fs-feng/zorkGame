package ch.informatik.m320.main.items;

public abstract class Item {
    private String name;
    private int weight;


    //constructor
    public Item(String itemName, int itemWeight){
        this.name = itemName;
        this.weight = itemWeight;
    }

    //abstract methods
    public abstract void useItem(); //method to use different items


    //getter
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
