package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.model.Pilot;
import org.springframework.stereotype.Service;

@Service
public class PilotCreator {

    public Pilot pilotCreator()
    {
        return Pilot.builder()
                .build();
    }
}
