package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.rooms.Room;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Entity{
    private Player player;
    public Enemy(Player player, Room room) {
        super(room);
        this.player = player;
    }
    public void goRoom() {
        String direction = null;
        Room nextRoom = null;
        while (nextRoom == null) {
            int door = ThreadLocalRandom.current().nextInt(1, 4);
            switch (door) {
                case 1:
                    direction = "north";
                    break;
                case 2:
                    direction = "south";
                    break;
                case 3:
                    direction = "west";
                    break;
                case 4:
                    direction = "east";
                    break;
                default:
                    direction = null;
                    break;
            }
            nextRoom = getCurrentRoom().nextRoom(direction);
        }

        move(nextRoom);
    }

    @Override
    protected void move(Room nextRoom) {
        setCurrentRoom(nextRoom);

    }
}
