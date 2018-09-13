package lidlapp.repos;

import lidlapp.models.Courier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CourierRepositoryTest {
    @Autowired
    private CourierRepository courierRepository;

    @Test
    void insertCourier() {
        var courier = new Courier();
        courier.setPickUpLocation("Hello World");
        courier.setEta(new Date());
        courier.setStatus("Hello World");
        var courierId = courierRepository.save(courier).getId();
        assertThat(courierId).isGreaterThan(0);
    }
}