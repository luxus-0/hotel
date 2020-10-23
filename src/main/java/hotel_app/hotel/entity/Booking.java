package hotel_app.hotel.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createdDate;

    private  Integer numberChildren;
    private  Integer numberAdult;
    private  Integer numberBed;

    @Enumerated(value = EnumType.STRING)
    private  Status status;

   @OneToOne(mappedBy = "booking")
   private Room room;

   @OneToOne(mappedBy = "booking")
   private Payment payment;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "booking_customers",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id")
    )
   private Set<Customer> customer;


    @ManyToMany
    @JoinTable(
            name = "booking_extras",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id", referencedColumnName = "id")
    )
    private Set<Extra> extras;

    public Booking(LocalDate createdDate, Integer numberChildren, Integer numberAdult, Integer numberBed) {
        this.createdDate = createdDate;
        this.numberChildren = numberChildren;
        this.numberAdult = numberAdult;
        this.numberBed = numberBed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(Integer numberChildren) {
        this.numberChildren = numberChildren;
    }


    public Integer getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(Integer numberAdult) {
        this.numberAdult = numberAdult;
    }

    public Integer getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(Integer numberBed) {
        this.numberBed = numberBed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
