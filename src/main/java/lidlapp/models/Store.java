package lidlapp.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Store {
    private Store() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String location;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
