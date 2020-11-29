package lukasz.nowogorski.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.model.Employee;
import lukasz.nowogorski.model.Extra;
import lukasz.nowogorski.repository.ExtraRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ExtraController {

    private final ExtraRepository extraRepository;
    
    @GetMapping("/extras")
    public List<Extra> getExtra()
    {
        return extraRepository.findAll();
    }

    @GetMapping("/extras/{id}")
    public Optional<Extra> getExtraById(@PathVariable Long id)
    {
        return extraRepository.findById(id);
    }

    @PostMapping("/extras")
    public Extra saveExtra(@RequestBody Extra extra)
    {
        return extraRepository.save(extra);
    }

    @PutMapping("/extras/{id]")
    public Employee updateExtra(@RequestBody Extra extra, @PathVariable Long id)
    {
        return extraRepository.updateExtra(extra,id);
    }

    @DeleteMapping("/extras")
    public void deleteExtra()
    {
        extraRepository.deleteAll();
    }

    @DeleteMapping("/extras/{id}")
    public void deleteExtra(@PathVariable Long id)
    {
        extraRepository.deleteById(id);
    }
}

