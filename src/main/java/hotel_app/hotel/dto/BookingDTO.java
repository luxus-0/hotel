package hotel_app.hotel.dto;

import hotel_app.hotel.entity.Customer;
import hotel_app.hotel.entity.Extra;
import hotel_app.hotel.entity.Room;

import java.util.Set;

public class BookingDTO {

    private Room room;
    private Set<Customer> customer;
    private Set<Extra> extras;

    public BookingDTO(Room room, Set<Customer> customer, Set<Extra> extras) {
        this.room = room;
        this.customer = customer;
        this.extras = extras;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    public Set<Extra> getExtras() {
        return extras;
    }

    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }
}
