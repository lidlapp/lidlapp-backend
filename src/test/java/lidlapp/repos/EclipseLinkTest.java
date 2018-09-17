package lidlapp.repos;

import lidlapp.models.Courier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

class EclipseLinkTest {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }

    @Test
    void insertCourier() {
        var courier = new Courier();
        courier.setPickUpLocation("Hello World");
        courier.setEta(new Date());
        courier.setStatus("Hello World");
        entityManager.persist(courier);
    }
}
