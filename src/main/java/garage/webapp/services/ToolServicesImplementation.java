package garage.webapp.services;

import garage.webapp.entity.Tool;
import garage.webapp.repositories.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksander on 05.05.2017.
 */


@Service
public class ToolServicesImplementation implements ToolServices {


    private GarageRepository garageRepository;

    @Autowired
    public void setGarageRepository(GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    @Override
    public Iterable<Tool> listAllTools(){
        return garageRepository.findAll();
    }

    @Override
    public Tool getToolById(Integer id){
        return garageRepository.findOne(id);
    }

    @Override
    public Tool saveTool(Tool tool){
        return garageRepository.save(tool);
    }

    @Override
    public void deleteTool(Integer id){
        garageRepository.delete(id);
    }



}
