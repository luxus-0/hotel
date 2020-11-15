package lukasz.nowogorski.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lukasz.nowogorski.domain.model.Gender;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestDto {

    private Long id;
    private String name;
    private String secondName;
    private String surname;
    private Gender gender;
    @Email(message = "message = Invalid email")
    private String email;
}
