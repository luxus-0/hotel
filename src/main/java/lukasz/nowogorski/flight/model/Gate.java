package lukasz.nowogorski.flight.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGate;
    private String name;
}
