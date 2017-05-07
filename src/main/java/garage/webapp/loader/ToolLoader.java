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
        hammer.setName("Great Hammer");
        hammer.setCategory("Hammers");
        hammer.setDescription("Great Hammer made by Ledo");
        garageRepository.save(hammer);

        logger.info("Saved hammer - id " + hammer.getId());

        Tool chainsaw = new Tool();
        chainsaw.setName("Chainsaw");
        chainsaw.setDescription("Shindaiwa Japaneese chainsaw");
        chainsaw.setCategory("Saws");
        garageRepository.save(chainsaw);

        logger.info("Saved chainsaw - id " + chainsaw.getId());

        Tool screwdriver = new Tool();
        screwdriver.setName("Screwdriver x4");
        screwdriver.setDescription("Stanley Steel Screwdriver x4");
        screwdriver.setCategory("screwdrivers");
        garageRepository.save(screwdriver);

        logger.info("Saved screwdriver - id " + screwdriver.getId());

        Tool screwdriver2 = new Tool();
        screwdriver2.setName("Screwdriver x2");
        screwdriver2.setDescription("Stanley Steel Screwdriver x2");
        screwdriver2.setCategory("Screwdrivers");
        garageRepository.save(screwdriver2);

        logger.info("Saved screwdriver2 - id " + screwdriver2.getId());

        Tool forkspanner  = new Tool();
        forkspanner.setName("Fork spanner 10x11");
        forkspanner.setDescription("Double fork spanner 10x11");
        forkspanner.setCategory("Forkspanners");
        garageRepository.save(forkspanner);

        logger.info("Saved forspanner - id " + forkspanner.getId());

        Tool forkspanner2  = new Tool();
        forkspanner2.setName("Fork spanner 12x13");
        forkspanner2.setDescription("Double fork spanner 12x13");
        forkspanner2.setCategory("Forkspanners");
        garageRepository.save(forkspanner2);

        logger.info("Saved forspanner2 - id " + forkspanner2.getId());

        Tool forkspanner3  = new Tool();
        forkspanner3.setName("Fork spanner 14x15");
        forkspanner3.setDescription("Double fork spanner 14x15");
        forkspanner3.setCategory("Forkspanners");
        garageRepository.save(forkspanner3);

        logger.info("Saved forspanner3 - id " + forkspanner3.getId());


    }

}
