package hotel_app.hotel.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RoomType {
    Economy("ECONOMY"), EconomyPremium("ECONOMY-PREMIUM"), Business("BUSINESS"), Luxury("I CLASS");

    private String description;
    private final String name;

    RoomType(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


}
