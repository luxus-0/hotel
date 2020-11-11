package lukasz.nowogorski.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

    @Id
    private Long id;
    private Integer adultNumber;
    private Integer childrenNumber;
    private Integer extraBedNumber;
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
