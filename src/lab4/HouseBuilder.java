package  lab4;

// Product
class House {
    private int floors;
    private int rooms;
    private String amenities;

    // Constructor with required parameters
    public House() {}

    // Setters for optional parameters
    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    // Getters
    public int getFloors() {
        return floors;
    }

    public int getRooms() {
        return rooms;
    }

    public String getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", rooms=" + rooms +
                ", amenities='" + amenities + '\'' +
                '}';
    }
}

// Builder
public interface HouseBuilder {
    House build();
    HouseBuilder buildFloors(int floors);
    HouseBuilder buildRooms(int rooms);
    HouseBuilder buildAmenities(String amenities);
}

// Concrete Builder
 class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    // Initialize house in the constructor
    public ConcreteHouseBuilder() {
        this.house = new House();
    }
    // Implement build method
    @Override
    public House build() {
        return this.house;
    }

    // Implement setters for optional parameters
    @Override
    public HouseBuilder buildFloors(int floors) {
        house.setFloors(floors);
        return this;
    }

    @Override
    public HouseBuilder buildRooms(int rooms) {
        house.setRooms(rooms);
        return this;
    }

    @Override
    public HouseBuilder buildAmenities(String amenities) {
        house.setAmenities(amenities);
        return this;
    }
}

// Director
 class HouseConstructionDirector {
    public House constructHouse(HouseBuilder builder) {
        // Use the builder to construct the house with necessary features
        return builder
                .buildFloors(2)
                .buildRooms(4)
                .buildAmenities("Garden, Garage")
                .build();
    }
}

class BuilderDemo {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseConstructionDirector director = new HouseConstructionDirector();

        // Director constructs house with default plan
        House house1 = director.constructHouse(builder);
        System.out.println(house1.toString());


        // Or, client can customize directly via builder
        House customHouse = new ConcreteHouseBuilder()
                .buildFloors(1).
                buildRooms(3)
                .build();
        System.out.println(customHouse.toString());
        customHouse.setAmenities("Swim pool, Garage");
        System.out.println(customHouse.toString());


    }
}

