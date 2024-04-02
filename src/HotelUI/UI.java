package HotelUI;

import HotelService.HotelService;

import java.util.ArrayList;
import java.util.Scanner;

import static HotelService.HotelService.profitabilityRatioo;

public class UI {
    static Scanner scanner = new Scanner(System.in);

    public static void addHotelRooms(ArrayList<HotelService> roomList){
        //TODO: creaza verificari (ID UNIC)

        System.out.println("Add ID: ");
        int id = scanner.nextInt();

        System.out.println("ADD ROOM NAME: ");
        String name = scanner.next();

        System.out.println("ADD PRICE: ");
        float price = scanner.nextFloat();

        System.out.println("ADD BEDS NUMBER: ");
        int bedsNumber = scanner.nextInt();

        System.out.println("ADD TYPE: ");
        String type = scanner.next();

        HotelService.addHotelRoom(roomList, id, name, price, bedsNumber, type);

    }

    public static void updateRoom(ArrayList<HotelService> roomList){

        System.out.println("ADD ID TO UPDATE");
        int idToUpdate = scanner.nextInt();
        System.out.println("ADD THE NEW PRICE");
        float newPrice = scanner.nextFloat();

        HotelService.updateRoom(roomList, idToUpdate, newPrice);
    }

    public static void displayRooms(ArrayList<HotelService> roomList){
        HotelService.displayRoom(roomList);
    }

    public static void removeRoom(ArrayList<HotelService> roomList){
        System.out.println("Remove room \n CHOSE THE ID YOU WANT TO REMOVE");
        int idToRemove = scanner.nextInt();
        HotelService.removeRoom(roomList, idToRemove);

    }
    public static void profitabilityRatio(ArrayList<HotelService> roomList){
        profitabilityRatioo(roomList);
    }
    public static void bedsRatio(ArrayList<HotelService> roomList){
        System.out.println("Chose room type");
        String roomType = scanner.next();
        HotelService.bedsRatio(roomList, roomType);
    }
    public static void menu() {
        ArrayList<HotelService> roomList = new ArrayList<>();
        HotelService.addHotelRoom(roomList, 1,"Regular 1", 50, 2, "Regular");
        HotelService.addHotelRoom(roomList, 2,"Regular 2", 55, 2, "Regular");
        HotelService.addHotelRoom(roomList, 3,"Regular 3", 60, 3, "Regular");

        HotelService.addHotelRoom(roomList, 6,"Business 1", 70, 2, "Business");
        HotelService.addHotelRoom(roomList, 5,"Business 2", 75, 2, "Business");
        HotelService.addHotelRoom(roomList, 4,"Business 3", 80, 3, "Business");

        HotelService.addHotelRoom(roomList, 9,"Executive 1", 90, 2, "Executive");
        HotelService.addHotelRoom(roomList, 7,"Executive 2", 95, 3, "Executive");
        HotelService.addHotelRoom(roomList, 8,"Executive 3", 100, 5, "Executive");

        HotelService.addHotelRoom(roomList, 11,"VIP 1", 110, 2, "VIP");
        HotelService.addHotelRoom(roomList, 12,"VIP 2", 120, 3, "VIP");
        HotelService.addHotelRoom(roomList, 10,"VIP 3", 130, 5, "VIP");

        int option;
        do {
            System.out.println("1. ADD HOTEL ROOM.");
            System.out.println("2. DISPLAY ROOM LIST.");
            System.out.println("3. UPDATE ROOM.");
            System.out.println("4. REMOVE ROOM");
            System.out.println("5. PROFITABILITY RATIO.");
            System.out.println("6. BEDS RATIO.");
            System.out.println("0. EXIT.");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addHotelRooms(roomList);
                    break;
                case 2:
                    displayRooms(roomList);
                    break;
                case 3:
                    updateRoom(roomList);
                    break;
                case 4:
                    removeRoom(roomList);
                case 5:
                    profitabilityRatio(roomList);
                    break;
                case 6:
                    bedsRatio(roomList);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 0);
    }
}

