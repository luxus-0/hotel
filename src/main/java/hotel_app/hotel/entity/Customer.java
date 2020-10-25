package hotel_app.hotel.entity;


import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Surname cannot be null")
    private String surname;

    @NotNull(message = "Pesel cannot be null")
    @Size(min = 0,max = 11)
    private Long pesel;

    @NotNull(message = "Gender cannot be null")
    private String gender;

    @NotNull(message = "Telephone cannot be null")
    private Long telephone;

    @Email
    @NotNull(message = "Email cannot be null")
    private String email;


    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message =
            "# a digit must occur at least once\n" +
            "# a lower case letter must occur at least once\n" +
            "# an upper case letter must occur at least once\n" +
            "# a special character must occur at least once\n" +
            "# no whitespace allowed in the entire string\n" +
            "# at least eight places though\n")
    private String password;

    public Customer() {
    }

    public Customer(String name, String surname, Long pesel, String gender, Long telephone, String email, String preferences, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
