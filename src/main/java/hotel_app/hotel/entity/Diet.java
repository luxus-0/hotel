package hotel_app.hotel.entity;

public enum Diet {

    Vegan("Vegan"),
    Vegetarian("Vegetarian"),
    GlutenIntolerant("Gluten Intolerant"),
    LactoseIntolerant("Lactose Intolerant");

    private final String description;

    Diet(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
