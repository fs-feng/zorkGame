package ch.informatik.m320.main.rooms;

//Class to create a String Array for each Room
public class RoomMapItem {
    private Room room;
    private String[] layout;
    private String[] leftDoor, rightDoor, bothDoor, noDoor, nullRoom;
    private String topDoor, topNoDoor;


    //constructor to assign the room
    public RoomMapItem(Room room) {
        this.room = room;

    }




    public void generateLayout(Room playerRoom) {
        layout = new String[5];
        setupStringTemplates(playerRoom);

        if (room != null) {
            if (room.getExits().get("north") != null)
                layout[0] = topDoor;
            else
                layout[0] = topNoDoor;


            if (room.getExits().get("east") != null && room.getExits().get("west") != null)
                for (int row = 1; row < 4; row++)
                    layout[row] = bothDoor[row - 1];
            else if (room.getExits().get("east") == null && room.getExits().get("west") != null)
                for (int row = 1; row < 4; row++)
                    layout[row] = leftDoor[row - 1];
            else if (room.getExits().get("east") != null && room.getExits().get("west") == null)
                for (int row = 1; row < 4; row++)
                    layout[row] = rightDoor[row - 1];
            else
                for (int row = 1; row < 4; row++)
                    layout[row] = noDoor[row - 1];

            if (room.getExits().get("south") != null)
                layout[4] = topDoor;
            else
                layout[4] = topNoDoor;
        } else  {
            for (int row = 0; row < 5; row++) {
                layout[row] = nullRoom[row];
            }
        }

    }

    private void setupStringTemplates(Room playerRoom) {
        topDoor = "#----------|  |----------#";
        topNoDoor = "#------------------------#";

        if (room != null) {
            noDoor = new String[] {
                    addName(),
                    "|                        |",
                    "|                        |",
            };
            rightDoor = new String[] {
                    addName(),
                    "|                         ",
                    "|                        -",
            };
            leftDoor = new String[] {
                    addName(),
                    "                         |",
                    "-                        |",
            };
            bothDoor = new String[] {
                    addName(),
                    "                          ",
                    "-                        -",
            };
        } else {
            nullRoom = new String[]{
                    "                          ",
                    "                          ",
                    "                          ",
                    "                          ",
                    "                          ",
            };
        }

    }

    private String addName() {
        int remaining = 23 - room.getDescription().length();
        String name;

        if (room.getExits().get("east") != null && room.getExits().get("west") != null) {
            name = "- " + room.getDescription();
            for (int i = 0; i < remaining; i++) {
                name = name + " ";
            }
            name = name + "-";
        } else if (room.getExits().get("east") == null && room.getExits().get("west") != null) {
            name = "- " + room.getDescription();
            for (int i = 0; i < remaining; i++) {
                name = name + " ";
            }
            name = name + "|";
        } else if (room.getExits().get("east") != null && room.getExits().get("west") == null) {
            name = "| " + room.getDescription();
            for (int i = 0; i < remaining; i++) {
                name = name + " ";
            }
            name = name + "-";
        } else {
            name = "| " + room.getDescription();
            for (int i = 0; i < remaining; i++) {
                name = name + " ";
            }
            name = name + "|";
        }


        return name;
    }

    //getter
    public String[] getLayout() {
        return layout;
    }

    public Room getRoom() {
        return room;
    }
}
