package lidlapp.controllers;

import com.google.common.base.Strings;
import lidlapp.models.Courier;
import lidlapp.repos.CourierRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("courier")
public class CourierController {
    private final CourierRepository repository;

    public CourierController(CourierRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Courier> getCouriers() {
        return repository.findAll();
    }

    @PostMapping
    public Courier newCourier(@RequestBody CourierSignUp body) throws Exception {
        // Validate input
        // Validate ETA
        //todo
        // Validate pick up location
        if (Strings.isNullOrEmpty(body.getPickUpLocation())) {
            throw new Exception("Provide a pick-up-location");
        }
//        body.setStatus();

        var courier = new Courier(null, null, body.getPickUpLocation(), body.getEta());
        repository.save(courier);
        return courier;
    }
}
