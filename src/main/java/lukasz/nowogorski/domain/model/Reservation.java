package lukasz.nowogorski.domain.model;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer adultNumber;

    @Column(nullable = false)
    private Integer childrenNumber;

    @Column(nullable = false)
    private Integer extraBedNumber;

    @Column(nullable = false)
    private Boolean isPayment;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Guest guest;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(Integer adultNumber) {
        this.adultNumber = adultNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(Integer childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Integer getExtraBedNumber() {
        return extraBedNumber;
    }

    public void setExtraBedNumber(Integer extraBedNumber) {
        this.extraBedNumber = extraBedNumber;
    }

    public Boolean getPayment() {
        return isPayment;
    }

    public void setPayment(Boolean payment) {
        isPayment = payment;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
