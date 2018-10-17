package lidlapp.controllers;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import lidlapp.models.Courier;
import lidlapp.repos.CourierRepository;
import lidlapp.repos.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/courier")
public class CourierController {
    private final CourierRepository courierRepository;
    private final UserRepository userRepository;

    public CourierController(CourierRepository courierRepository, UserRepository userRepository) {
        this.courierRepository = courierRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Courier[] getCouriers(Authentication authentication) {
        return Iterables.toArray(courierRepository.findAll(), Courier.class);
    }

    @PostMapping
    public Courier signUp(@RequestBody Courier body, Authentication auth) throws SignUpException {
        // Validate ETA
        if (body.getEta().before(new Date())) {
            // ETA in the past
            throw new SignUpException("ETA is in the past");
        }
        // Validate pick up location
        if (Strings.isNullOrEmpty(body.getPickUpLocation())) {
            throw new SignUpException("Provide a pick-up-location");
        }
        // Validate store
        if (Strings.isNullOrEmpty(body.getStore())) {
            throw new SignUpException("Provide a store");
        }

        var user = userRepository.findByAuth(auth);
        var courier = new Courier(user, body.getStore(), body.getPickUpLocation(), body.getEta());
        courierRepository.save(courier);
        return courier;
    }

    class SignUpException extends Exception {
        public SignUpException(String message) {
            super(message);
        }
    }
}
