package lidlapp.controllers;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import lidlapp.models.Courier;
import lidlapp.repos.CourierRepository;
import lidlapp.repos.StoreRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courier")
public class CourierController {
    private final CourierRepository courierRepository;
    private final StoreRepository storeRepository;

    public CourierController(CourierRepository courierRepository, StoreRepository storeRepository) {
        this.courierRepository = courierRepository;
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public Courier[] getCouriers(Authentication authentication) {
        return Iterables.toArray(courierRepository.findAll(), Courier.class);
    }

    @PostMapping
    public Courier newCourier(@RequestBody CourierSignUp body, Authentication auth) throws Exception {
        // Validate input
        // Validate ETA
        //todo
        // Validate pick up location
        if (Strings.isNullOrEmpty(body.getPickUpLocation())) {
            throw new Exception("Provide a pick-up-location");
        }
//        body.setStatus();
        var store = storeRepository.findById(body.getStoreId()).orElseThrow();
        var courier = new Courier(null, store, body.getPickUpLocation(), body.getEta());
        courierRepository.save(courier);
        return courier;
    }
}
