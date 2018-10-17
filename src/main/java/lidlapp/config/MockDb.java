package lidlapp.config;

import lidlapp.models.Chain;
import lidlapp.models.Courier;
import lidlapp.models.Store;
import lidlapp.models.User;
import lidlapp.repos.CourierRepository;
import lidlapp.repos.StoreRepository;
import lidlapp.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class MockDb implements CommandLineRunner {

    private final Environment environment;
    private final UserRepository userRepository;
    private final CourierRepository courierRepository;
    private final StoreRepository storeRepository;
    private Logger logger = LoggerFactory.getLogger(MockDb.class);

    public MockDb(Environment environment, UserRepository userRepository, CourierRepository courierRepository, StoreRepository storeRepository) {
        this.environment = environment;
        this.userRepository = userRepository;
        this.courierRepository = courierRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean development = Arrays.asList(environment.getActiveProfiles()).contains("development");
        if (development) {
            fillDatabase();
        }
    }

    private void fillDatabase() {
        var chain = new Chain("Lidl", "", "https://www.lidl.nl/");
        var store = new Store("Lidl", "51445485,5487261", chain);
        storeRepository.save(store);
        var user = new User("henk@mail", "Henkie", "myId");
        userRepository.save(user);
        var courier = new Courier(user, "Lidl", "Open ruimte op de 3e", new Date());
        courierRepository.save(courier);

        logger.info("Mock user has id {}", user.getId());
        logger.info("Mock store has id {}", store.getId());
        logger.info("Mock courier has id {}", courier.getId());
    }
}
