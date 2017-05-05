package garage.webapp.loader;

import garage.webapp.entity.Tool;
import garage.webapp.repositories.GarageRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



/**
 * Created by Aleksander on 05.05.2017.
 */

@Component
public class ToolLoader implements ApplicationListener<ContextRefreshedEvent> {


    private GarageRepository garageRepository;

    private Logger logger = Logger.getLogger(ToolLoader.class);

    @Autowired
    public void setGarageRepository(GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        Tool hammer = new Tool();
        hammer.setName("GreatHammer");
        hammer.setCategory("Building tool");
        hammer.setDescription("5 kg of pure steel");
        garageRepository.save(hammer);

        logger.info("Saved hammer - id " + hammer.getId());

        Tool chainsaw = new Tool();
        chainsaw.setName("Husqvaqna Chainsaw");
        chainsaw.setDescription("Heavy Japaneese chainsaw");
        chainsaw.setCategory("Heavy tool");
        garageRepository.save(chainsaw);

        logger.info("Saved chainsaw - id " + chainsaw.getId());
    }

}
