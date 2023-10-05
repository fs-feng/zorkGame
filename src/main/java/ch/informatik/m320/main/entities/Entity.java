package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.rooms.Room;

public abstract class Entity {
    private Room currentRoom;
    private int health;


    //Constructor
    public Entity(Room currentRoom, int health) {
        this.currentRoom = currentRoom; //Set starting room
        this.health = health;
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


    public void setHealth(int health){
        this.health += health;
    }

    //heal function for the medkit, if health after healing > 100, then set health to 100
    public void heal(int health){
        this.health += health;
        if(health>100){
            this.health = 100;
        }
    }
}
