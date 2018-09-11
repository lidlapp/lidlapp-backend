package lidlapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
    private OrderItem() {
    }

    @Id
    @GeneratedValue
    private Long id;

    //todo: Add properties
}
