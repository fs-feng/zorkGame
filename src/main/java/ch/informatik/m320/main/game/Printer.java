package ch.informatik.m320.main.game;

import ch.informatik.m320.main.entities.Enemy;
import ch.informatik.m320.main.entities.Player;
import ch.informatik.m320.main.rooms.Room;
import ch.informatik.m320.main.rooms.RoomMap;

public class Printer {
    private Player player;
    private Enemy enemy;
    private Parser parser;
    private RoomMap roomMap;

    public Printer(Player player, Enemy enemy, Parser parser, Room[][] roomArray) {
        this.player = player;
        this.parser = parser;
        this.enemy = enemy;
        roomMap = new RoomMap(roomArray);
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Zork!");
        System.out.println("Zork is a simple adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().longDescription());
    }
    public void printHelp() {
        System.out.println("You just woke up in an aircraft which seems to be abandoned.");
        System.out.println("Your aircraft got invaded by a foreign lifeform.");
        System.out.println("You have to gather ship parts to repair your escape pod");
        System.out.println("StunGuns are scattered across the ship to help fend off the alien");
        System.out.println("MedKits can heal you up again");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
        System.out.println("Use pick ItemName to pick up item");
        System.out.println("Use drop ItemName to drop item");
        System.out.println("Use inventory to show inventory and health");
        System.out.println("Use use to use item");
        System.out.println("Use back to go back");
        System.out.println("Use escape in escape to escape the ship");
    }

    public void printWin() {

    }

    public void printMap() {
        roomMap.printMap(player.getCurrentRoom(), enemy.getCurrentRoom());
    }
}
