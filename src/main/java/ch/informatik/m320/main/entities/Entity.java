package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.rooms.Room;

public abstract class Entity {
    private Room currentRoom;
    private int health;


    //Constructor
    public Entity(Room currentRoom) {
        this.currentRoom = currentRoom; //Set starting room
    }

    //abstract method for moving
    protected abstract void move(Room room);


    //Getter and Setter
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


}
