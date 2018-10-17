package lidlapp.repos;

import lidlapp.config.JpaConfiguration;
import lidlapp.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(JpaConfiguration.class)
class CourierRepositoryTest {
    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void insertCourier() {
        var courier = new Courier();
        courier.setPickUpLocation("Hello World");
        courier.setEta(new Date());
        courier.setStatus(CourierStatus.ON_THE_WAY);
        var courierId = courierRepository.save(courier).getId();
        assertThat(courierId).isGreaterThan(0);
    }

    @Test
    void insertStore() {
        var chain = new Chain("Albert Hein", "", "");
        var store = new Store("Albert Hein", "", chain);
        storeRepository.save(store);
    }
}