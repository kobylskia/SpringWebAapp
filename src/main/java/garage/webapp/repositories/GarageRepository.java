package garage.webapp.repositories;

import garage.webapp.entity.Tool;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aleksander on 05.05.2017.
 */
public interface GarageRepository extends CrudRepository<Tool, Integer> {
}
