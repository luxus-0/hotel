package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Category;
import lukasz.nowogorski.domain.model.Extra;
import lukasz.nowogorski.domain.model.Food;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CostFoodService {

    public void setFoodExtra(Set<Extra> foodExtras)
    {
        boolean containCategory = foodExtras.stream().anyMatch(e -> e.getCategory() != Category.Food);
        if (containCategory) {
            throw new IllegalArgumentException("Contains invalid categories that are not Extra.Category.Food");
        }

    }
}
