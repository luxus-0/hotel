package lukasz.nowogorski.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String secondName;
    private String surname;
    private Gender gender;
    private Long pesel;
    private String nationality;
    private String telephone;
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "guests")
    private Set<Reservation> reservations;

    public Guest() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getPesel() {
        return pesel;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
}
