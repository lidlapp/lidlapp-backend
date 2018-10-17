package lidlapp.controllers;

import lidlapp.models.OrderItem;
import lidlapp.repos.CourierRepository;
import lidlapp.repos.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final UserRepository userRepository;
    private final CourierRepository courierRepository;

    public OrderController(UserRepository userRepository, CourierRepository courierRepository) {
        this.userRepository = userRepository;
        this.courierRepository = courierRepository;
    }

    @PostMapping
    void enterOrder(@RequestBody OrderRequest orderRequest, Authentication auth) {
        var user = userRepository.findByAuth(auth);
        var courier = courierRepository.findById(orderRequest.courierId).orElseThrow();
        // FIXME: 2018-10-17 Error message when courier not found
        for (String product : orderRequest.products) {
            user.addOrder(courier, product);
        }
        userRepository.save(user);
    }

    @GetMapping
    Iterable<OrderItem> getRequestedOrders(Authentication auth) {
        var user = userRepository.findByAuth(auth);
        return user.getOrders();
    }

    static class OrderRequest {
        public String[] products;
        public Long courierId;
    }
}
