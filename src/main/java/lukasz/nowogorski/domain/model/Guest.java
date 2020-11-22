package lukasz.nowogorski.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @Email(message = "Invalid email")
    private String email;
    @Length(min = 6, max = 15, message = "Invalid length password")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]-).{6,15}")
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private Boolean child;

    @ManyToMany(mappedBy = "guests")
    private Set<Reservation> reservations;


}
