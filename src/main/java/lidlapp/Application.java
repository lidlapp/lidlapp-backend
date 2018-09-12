package lidlapp;

import com.google.common.collect.Iterators;
import lidlapp.repos.CourierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourierRepository courierRepository) {
        return args -> {
            var couriers = courierRepository.findAll();
            int count = Iterators.size(couriers.iterator());
            System.out.printf("Found %d couriers.%n", count);
        };
    }
}
