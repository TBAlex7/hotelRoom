package HotelService;

import java.util.*;

public class HotelService {
    int id;
    String name;
    float price;
    int beds;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HotelService(int id, String name, float price, int beds, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.beds = beds;
        this.type = type;
    }

    public HotelService() {
    }

    public static void addHotelRoom(ArrayList<HotelService> roomList, int id, String name, float price, int beds, String type) {
        HotelService hotelServiceRoom = new HotelService(id, name, price, beds, type);
        roomList.add(hotelServiceRoom);
    }

    public static void updateRoom(ArrayList<HotelService> roomList, int idToUpdate, float newPrice) {
        for (HotelService hotelService : roomList) {
            if (hotelService.getId() == idToUpdate) {
                hotelService.setPrice(newPrice);
            }
        }
    }

    public static void displayRoom(ArrayList<HotelService> roomList) {
        roomList.sort((hotelService1, hotelService2) -> hotelService1.getId() - hotelService2.getId());
        //if roomlist = empty --> mesaj
        //else
        for (HotelService hotelService : roomList) {
            System.out.println(hotelService.getId() + " NAME: " + hotelService.getName() + " PRICE: " + hotelService.getPrice() + " BEDS: "
                    + hotelService.getBeds() + " TYPE: " + hotelService.getType());
        }
    }

    public static void removeRoom(ArrayList<HotelService> roomList, int idToRemove) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == idToRemove) {
                roomList.remove(i);
                break;
            }
        }
    }

    public static void profitabilityRatioo(ArrayList<HotelService> roomList) {
        for (HotelService hotelService : roomList) {
            float revenuePerBed = hotelService.getPrice() / hotelService.getBeds();
            System.out.println(hotelService.getId() + " NAME: " + hotelService.getName() + " PRICE: " + hotelService.getPrice() + " BEDS "
                    + hotelService.getBeds() + " TYPE: " + hotelService.getType()+ " REVENUE/ BED " +revenuePerBed);
        }
    }

    public static void bedsRatio(ArrayList<HotelService> roomList, String roomType) {
        ArrayList<Integer> beds = new ArrayList<>();
        int sum = 0;
        int avrage = 0;
        String type = null;

        for(HotelService hotel: roomList) {
            if (hotel.getType().equals(roomType)) {
                int bed = hotel.getBeds();
                type = hotel.getType();
                beds.add(bed);
                sum += bed;
                avrage = sum/beds.size();
            }
        }
        System.out.println("Room type:" + type + " " + " Avrage beds/ room: " + avrage);
       }
    }





