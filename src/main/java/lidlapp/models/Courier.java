package lidlapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Courier {
    private Courier() {
    }

    @Id
    @GeneratedValue
    private Long id;

    //todo: Add properties
}
