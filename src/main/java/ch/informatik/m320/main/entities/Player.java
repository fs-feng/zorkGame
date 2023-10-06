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
        super(room, 100);
        inventory = new Inventory();
        this.maxWeight = 10;
        lastRooms = new ArrayList<>();
    }

    public void useItem(Command command, Enemy enemy) {
        if (!command.hasSecondWord()) {
            System.out.println("Use what item?");
        } else {

            String itemName = command.getSecondWord();
            boolean isItem = false;
            for (int index = 0; index <  inventory.getInventory().size(); index++) {
                if (inventory.getInventory().get(index).getName().equals(itemName)) {
                    if (enemy.getCurrentRoom() == getCurrentRoom() && itemName.equals("StunGun"))  //damage enemy when it is in the same room
                        stunGunUsed = true;
                    inventory.getInventory().get(index).use(this, index);
                    isItem = true;
                }
            }

            if (!isItem) {
                System.out.println("You don't have this item");
            }
        }

    }




    public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what item?");
        } else {
            String itemName = command.getSecondWord();


            for (int index = 0; index <  inventory.getInventory().size(); index++) {
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
            boolean isItem = false;
            for (int index = 0; index <  roomInventory.size(); index++) {
                if (roomInventory.get(index).getName().equals(itemName)) {
                    pickUp(index, getCurrentRoom().getInventory());
                    isItem = true;
                }
            }

            if (!isItem)
                System.out.println("What item do you mean?us");
        }
    }

    private void pickUp(int index, Inventory roomInventory) {
        int weight = 0;
        for (Item item: inventory.getInventory()) {
            weight += item.getWeight();
        }
        weight += roomInventory.getInventory().get(index).getWeight();
        if (weight <= maxWeight) {
            System.out.println("Added: " + roomInventory.getInventory().get(index).getName() + " to inventory");
            inventory.addItem(roomInventory.removeItem(index));
        } else {
            System.out.println("It's " + (weight - maxWeight) + "kg too heavy");
        }
    }

    public void showInventory() {
        int weight = 0;
        for (Item item: inventory.getInventory()) {
            System.out.printf(item.getName() + ", " + item.getWeight() + "kg | ");
            weight += item.getWeight();
        }
        System.out.printf("capacity: " + weight + "kg /" + maxWeight + "kg   || Health: " + getHealth() + " / 100");
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

    @Override
    public void kill() {
        if (getHealth() <= 0) {
            setAlive(false);
            System.out.println("You have been killed by the alien");
        }
    }


    //getter and setter
    public Inventory getInventory() {
        return inventory;
    }
}
