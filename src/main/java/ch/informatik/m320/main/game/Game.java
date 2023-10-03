package ch.informatik.m320.main.game;import ch.informatik.m320.main.rooms.Room;/** * Class Game - the main class of the "Zork" game. * * Author:  Michael Kolling, 1.1, March 2000 * refactoring: Rinaldo Lanza, September 2020 */public class Game {		private Parser parser;	private Room currentRoom, lastRoom;	private Room sleepingquarters, gun1, gun2, reactor, mensa, cockpit, supplyroom, engine1, engine2, escapepod;	public Game() {				parser = new Parser(System.in);		sleepingquarters = new Room("Sleeping Quarters");		gun1= new Room("gun2");		gun2 = new Room("gun1");		reactor = new Room("reactor");		mensa = new Room("mensa");		cockpit = new Room("cockpit");		supplyroom = new Room("Supply Room");		engine1 = new Room("Engine Room 1");		engine2 = new Room("Engine Room 2");		escapepod = new Room("Escape Pods");		sleepingquarters.setExits(reactor, engine2, escapepod, gun2);		gun1.setExits(engine1, null, engine2, null);		gun2.setExits(null, sleepingquarters, null, null);		reactor.setExits(mensa, null, sleepingquarters, null);		mensa.setExits(supplyroom, cockpit, reactor, engine1);		cockpit.setExits(null, mensa, null, null);		supplyroom.setExits(null, null, mensa, null);		engine1.setExits(null, null, gun1, mensa);		engine2.setExits(gun1, null, null, sleepingquarters);		escapepod.setExits(sleepingquarters, null, null, null);		currentRoom = cockpit; // start game in cockpit	}	/**	 *  Main play routine.  Loops until end of play.	 */	public void play() {		printWelcome();		// Enter the main command loop.  Here we repeatedly read commands and		// execute them until the game is over.		boolean finished = false;		while (!finished) {			Command command = parser.getCommand();			finished = processCommand(command);		}		System.out.println("Thank you for playing.  Good bye.");	}	private void printWelcome() {		System.out.println();		System.out.println("Welcome to Zork!");		System.out.println("Zork is a simple adventure game.");		System.out.println("Type 'help' if you need help.");		System.out.println();		System.out.println(currentRoom.longDescription());	}	private boolean processCommand(Command command) {		if (command.isUnknown()) {			System.out.println("I don't know what you mean...");			return false;		}		String commandWord = command.getCommandWord();		if (commandWord.equals("help")) {			printHelp();		} else if (commandWord.equals("go")) {			goRoom(command);					} else if (commandWord.equals("back")){			backRoom();		} else if (commandWord.equals("quit")) {			if (command.hasSecondWord()) {				System.out.println("Quit what?");			} else {				return true; // signal that we want to quit			}		}		return false;	}	private void printHelp() {		System.out.println("You are lost. You wake up alone. You're");		System.out.println("in an aircraft which seems to be abandoned.");		System.out.println();		System.out.println("Your command words are:");		System.out.println(parser.showCommands());	}	private void goRoom(Command command) {		if (!command.hasSecondWord()) {			System.out.println("Go where?");		} else {						String direction = command.getSecondWord();				// Try to leave current room.			Room nextRoom = currentRoom.nextRoom(direction);				if (nextRoom == null)				System.out.println("There is no door!");			else {				lastRoom = currentRoom;				currentRoom = nextRoom;				System.out.println(currentRoom.longDescription());			}		}	}	private void backRoom() {		if (lastRoom == null)			System.out.println("You don't remember where you came from");		else {			currentRoom = lastRoom;			lastRoom = null;			System.out.println(currentRoom.longDescription());		}	}}