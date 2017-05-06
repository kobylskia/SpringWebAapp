package garage.webapp.repositories;

import garage.webapp.entity.Tool;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Aleksander on 05.05.2017.
 */
public interface GarageRepository extends CrudRepository<Tool, Integer> {

    public List<Tool> findByNameContaining(String name);
}
