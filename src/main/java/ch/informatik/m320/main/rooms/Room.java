package ch.informatik.m320.main.rooms;/** * Author:  Michael Kolling, Version: 1.1, Date: August 2000 * refactoring: Rinaldo Lanza, September 2020 */import ch.informatik.m320.main.items.Inventory;import ch.informatik.m320.main.items.Item;import java.util.ArrayList;import java.util.HashMap;public class Room {	private boolean winCon;	private String description;	private HashMap<String, Room> exits;	private Inventory inventory; //Inventory to holdd items	public Room(String description) {		this.description = description;		this.exits = new HashMap<>();		inventory = new Inventory();	}	public Room(String description, boolean winCon) {		this.description = description;		this.exits = new HashMap<>();		this.winCon	= winCon;		inventory = new Inventory();	}	//method to set the exits of a room	public void setExits(Room north, Room east, Room south, Room west) {		exits.put("north", north);		exits.put("east", east);		exits.put("south", south);		exits.put("west", west);	}	//short description of the room, mostly just the room name	public String shortDescription() {		return description;	}	//description of the room, returns "you are in" + description + "."	public String longDescription() {		StringBuilder stringBuilder = new StringBuilder("You are in " + description + ".\n");		stringBuilder.append(exitString());		return stringBuilder.toString();	}	//gets possible all exits output as string together seperated by " "	private String exitString() {		return "Exits:" + String.join(" ", exits.keySet());	}	//gets the available exit direction	public Room nextRoom(String direction) {		return exits.get(direction);	}	//getter and setter	public Inventory getInventory() {		return inventory;	}	public String getDescription() {		return description;	}	public HashMap<String, Room> getExits() {		return exits;	}	public void setWinCon(boolean winCon) {		this.winCon = winCon;	}}