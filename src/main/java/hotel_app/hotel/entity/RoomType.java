package hotel_app.hotel.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RoomType {
    Economy("ECONOMY"), EconomyPremium("ECONOMY-PREMIUM"), Business("BUSINESS"), Luxury("APARTMENT");

    private final String name;

    RoomType(String name) {
        this.name = name;
    }


   public Double getPriceForRoomType()
   {
        if(RoomType.Economy.name.equals("ECONOMY"))
        {
            return 25.40;
        }

       if(RoomType.Economy.name.equals("ECONOMY-PREMIUM"))
       {
           return 35.78;
       }

       if(RoomType.Economy.name.equals("BUSINESS"))
       {
           return 49.78;
       }

       if(RoomType.Economy.name.equals("APARTMENT"))
       {
           return 49.78;
       }

        return Double.NaN;


   }


}
