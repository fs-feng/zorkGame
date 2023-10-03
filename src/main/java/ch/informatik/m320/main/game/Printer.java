package ch.informatik.m320.main.game;

import ch.informatik.m320.main.entities.Player;
import ch.informatik.m320.main.rooms.Room;
import ch.informatik.m320.main.rooms.RoomMap;

public class Printer {
    private Player player;
    private Parser parser;
    private RoomMap roomMap;

    public Printer(Player player, Parser parser, Room[][] roomArray) {
        this.player = player;
        this.parser = parser;
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
        System.out.println("You are lost. You wake up alone. You're");
        System.out.println("in an aircraft which seems to be abandoned.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    public void printMap() {
        roomMap.printMap(player.getCurrentRoom());
    }
}
