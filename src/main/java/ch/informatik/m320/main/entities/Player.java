package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.items.Inventory;
import ch.informatik.m320.main.items.Item;
import ch.informatik.m320.main.rooms.Room;

import java.util.ArrayList;

public class Player extends Entity{
    private Inventory inventory; //Inventory to hold Items
    private int maxWeight; //maxWeight for Items
    private ArrayList<Room> lastRooms;


    public Player(Room room) {
        super(room);

        inventory = new Inventory();
        this.maxWeight = 20;
        lastRooms = new ArrayList<>();
    }

    public boolean useItem(Command command, Enemy enemy) {
        if (!command.hasSecondWord()) {
            System.out.println("Use what item?");
        } else {

            String itemName = command.getSecondWord();

            for (int index = 0; index <  inventory.getInventory().size(); index++) {
                System.out.println(inventory.getInventory().get(index).getName());
                if (inventory.getInventory().get(index).getName().equals(itemName)) {
                    return inventory.getInventory().get(index).use(this, index);
                }
            }
        }
        System.out.println("You don't have that item");
        return false;
    }


    public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what item?");
        } else {
            String itemName = command.getSecondWord();


            for (int index = 0; index <  inventory.getInventory().size(); index++) {
                System.out.println(inventory.getInventory().get(index).getName());
                if (inventory.getInventory().get(index).getName().equals(itemName)) {
                    dropDown(index, getCurrentRoom().getInventory());
                }
            }
        }
    }

    private void dropDown(int index, Inventory roomInventory) {
        roomInventory.addItem(inventory.removeItem(index));
    }

    public void pickItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pick up what?");
        } else {
            String itemName = command.getSecondWord();

            ArrayList<Item> roomInventory = getCurrentRoom().getInventory().getInventory();

            for (int index = 0; index <  roomInventory.size(); index++) {
                System.out.println(roomInventory.get(index).getName());
                if (roomInventory.get(index).getName().equals(itemName)) {

                    pickUp(index, getCurrentRoom().getInventory());
                }
            }
        }
    }

    private void pickUp(int index, Inventory roomInventory) {
        int weight = 0;
        for (Item item: inventory.getInventory()) {
            weight += item.getWeight();
        }
        weight += roomInventory.getInventory().get(index).getWeight();
        if (weight <= maxWeight) {
            inventory.addItem(roomInventory.removeItem(index));
        } else {
            System.out.println("It's " + (weight - maxWeight) + "too heavy");
        }
    }

    public void showInventory() {
        for (Item item: inventory.getInventory()) {
            System.out.printf(item.getName() + ", " + item.getWeight() + "kg | ");
        }
        System.out.println();
    }



    //function to move and check if possible
    public void goRoom(Command command) { //command object with 1 or 2 keywords
        if (!command.hasSecondWord()) { //missing direction
            System.out.println("Go where?");
        } else {
            // Get Room direction
            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = getCurrentRoom().nextRoom(direction);

            if (nextRoom == null) // check if door is available
                System.out.println("There is no door!");
            else {
                lastRooms.add(getCurrentRoom()); // add currentRoom to room history
                move(nextRoom); //call move
            }
        }
    }

    //move one room back
    public void goBack() {
        if (lastRooms.isEmpty()) //check if lastrooms is = to startRoom
            System.out.println("This is where I came from");
        else {
            move(lastRooms.get(lastRooms.size() - 1)); // move player one room back
            lastRooms.remove(lastRooms.get(lastRooms.size() - 1)); //remove latest room
        }
    }

    //actually move the player
    @Override
    protected void move(Room nextRoom) {
        setCurrentRoom(nextRoom); //change rooms
        System.out.println(getCurrentRoom().longDescription()); //show description
    }


    //getter and setter
    public Inventory getInventory() {
        return inventory;
    }
}
