package lidlapp;

import lidlapp.models.Chain;
import lidlapp.models.Courier;
import lidlapp.models.Store;
import lidlapp.models.User;
import lidlapp.repos.CourierRepository;
import lidlapp.repos.StoreRepository;
import lidlapp.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, CourierRepository courierRepository, StoreRepository storeRepository) {
        return args -> {
            var chain = new Chain("Lidl", "", "https://www.lidl.nl/");
            var store = new Store("Lidl", "51445485,5487261", chain);
            storeRepository.save(store);
            var user = new User("henk@mail", "Henkie");
            userRepository.save(user);
            var courier = new Courier(user, store, "Open ruimte op de 3e", new Date());
            courierRepository.save(courier);
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
