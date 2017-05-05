package garage.webapp.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Aleksander on 05.05.2017.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"garage.webapp.entity"})
@EnableJpaRepositories(basePackages = {"garage.webapp.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
