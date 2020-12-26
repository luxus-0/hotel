package lukasz.nowogorski.hotel.model;

import lombok.Getter;

@Getter
public enum Diet {
    Vegetarian("vegetarian"),
    Vegan("Vegan"),
    Gluten("Gluten intolerant"),
    LactoseIntolerant("Lactose Intolerant");

    private final String info;

    Diet(String info) {
        this.info = info;
    }
}
