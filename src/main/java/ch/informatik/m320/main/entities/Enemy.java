package ch.informatik.m320.main.entities;

import ch.informatik.m320.main.game.Command;
import ch.informatik.m320.main.rooms.Room;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Entity{
    private Player player;
    public Enemy(Player player, Room room) {
        super(room, 100);
        this.player = player;
    }
    public void goRoom() {
        String direction;
        Room nextRoom = null;
        while (nextRoom == null) {
            int door = ThreadLocalRandom.current().nextInt(1, 6);
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
                case 5:
                    direction = "stay";
                    break;
                default:
                    direction = null;
                    break;
            }
            if (direction.equals("stay"))
                nextRoom = getCurrentRoom();
            else
                nextRoom = getCurrentRoom().nextRoom(direction);
        }

        move(nextRoom);
    }

    @Override
    protected void move(Room nextRoom) {
        setCurrentRoom(nextRoom);
    }


    public void kill() {
        if (getHealth() <= 0) {
            setAlive(false);
            setCurrentRoom(null);
            System.out.println("You killed the alien, you are save now");
        }
    }

    public void attack() {
        if (player.getCurrentRoom() == getCurrentRoom()) {
            if (stunGunUsed) {
                stunGunUsed = false;
            } else {
                player.setHealth(player.getHealth() - 40);
                System.out.println("\u001B[31m" + "The alien attacked you for 40 damage" + "\u001B[0m");
                player.kill();
            }
        }
    }


}
