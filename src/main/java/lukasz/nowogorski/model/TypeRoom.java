package lukasz.nowogorski.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeRoom {
    STANDARD(2,500),STANDARD_PLUS(2,600),
    EXCLUSIVE(2,700),EXCLUSIVE_PLUS(2,800),
    APARTMENT(2,1000);

    private final Integer NumberBeds;
    private final float price;

}
