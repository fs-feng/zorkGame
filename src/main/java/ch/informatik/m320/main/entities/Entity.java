package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.rooms.Room;

public abstract class Entity {
    private Room currentRoom;
    private int health;
    private boolean isAlive;

    //class variable to check if stungun is used
    protected static boolean stunGunUsed = false;


    //Constructor
    public Entity(Room currentRoom, int health) {
        this.currentRoom = currentRoom; //Set starting room
        this.health = health;

        isAlive = true;
    }

    //abstract method for moving
    protected abstract void move(Room room);
    public abstract void kill();


    //Getter and Setter
    public Room getCurrentRoom() {
        return currentRoom;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }




    //getter and setter
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
