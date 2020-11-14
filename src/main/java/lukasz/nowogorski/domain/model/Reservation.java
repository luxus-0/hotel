package lukasz.nowogorski.domain.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer adultNumber;
    private Integer childrenNumber;
    private Integer extraBedNumber;
    private String payment;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "reservation_guests",
            joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id")
    )
    private final Set<Guest> guests=new HashSet<>();

    @OneToOne(mappedBy = "reservation")
    private Room room;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public Integer getAdultNumber() {
        return adultNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public Integer getExtraBedNumber() {
        return extraBedNumber;
    }

    public String getPayment() {
        return payment;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public Room getRoom() {
        return room;
    }
}
