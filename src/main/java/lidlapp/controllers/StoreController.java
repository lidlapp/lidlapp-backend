package lidlapp.controllers;

import com.google.common.collect.Iterables;
import lidlapp.models.Store;
import lidlapp.repos.StoreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/store")
public class StoreController {
    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public Store[] getStores() {
        return Iterables.toArray(storeRepository.findAll(), Store.class);
    }
}
