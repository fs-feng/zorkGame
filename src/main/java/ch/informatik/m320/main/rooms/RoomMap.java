package ch.informatik.m320.main.rooms;

import ch.informatik.m320.main.entities.Player;

public class RoomMap {
    private RoomMapItem[][] map;
    private String[] legende;
    private String[][] roomMap;

    public RoomMap(Room[][] roomArray) {
        setupMapItems(roomArray);
    }


    //use 2d array of rooms to asign to RoomMapItem
    private void setupMapItems(Room[][] roomArray) {
        map = new RoomMapItem[5][3];
        roomMap = new String[25][3];

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                map[row][col] = new RoomMapItem(roomArray[row][col]);
            }
        }
    }

    public void printMap(Room playerRoom) {
        String black = 	"\u001B[0m";
        String green = "\u001B[32m";
        int count1 = 0, count2 = 0, count3 = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                map[row][col].generateLayout(playerRoom);

                for (int iteration = 0; iteration < 5; iteration++) {
                    if (playerRoom == map[row][col].getRoom()) {
                        switch (col) {
                            case 0:
                                roomMap[count1][col] = green + map[row][col].getLayout()[iteration] + black;
                                count1++;
                                break;
                            case 1:
                                roomMap[count2][col] = green + map[row][col].getLayout()[iteration] + black;
                                count2++;
                                break;
                            case 2:
                                roomMap[count3][col] = green + map[row][col].getLayout()[iteration] + black;
                                count3++;
                                break;
                        }
                    } else {
                        switch (col) {
                            case 0:
                                roomMap[count1][col] = map[row][col].getLayout()[iteration];
                                count1++;
                                break;
                            case 1:
                                roomMap[count2][col] = map[row][col].getLayout()[iteration];
                                count2++;
                                break;
                            case 2:
                                roomMap[count3][col] = map[row][col].getLayout()[iteration];
                                count3++;
                                break;
                        }

                    }
                }
            }
        }

        for (int row = 0; row < 25; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.printf(roomMap[row][col]);
            }
            System.out.println();
        }


    }


}
