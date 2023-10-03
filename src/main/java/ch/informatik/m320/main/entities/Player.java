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
