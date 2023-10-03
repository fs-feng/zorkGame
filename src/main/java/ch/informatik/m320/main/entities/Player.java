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




    public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
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
                move(nextRoom);
            }
        }
    }

    public void goBack() {
        if (lastRooms.isEmpty())
            System.out.println("You don't remember where you came from");
        else {
            move(lastRooms.get(lastRooms.size() - 1));
            lastRooms.remove(lastRooms.get(lastRooms.size() - 1));
        }
    }

    @Override
    protected void move(Room nextRoom) {
        setCurrentRoom(nextRoom); //change rooms
        System.out.println(getCurrentRoom().longDescription());
    }


    //getter and setter
    public Inventory getInventory() {
        return inventory;
    }
}
