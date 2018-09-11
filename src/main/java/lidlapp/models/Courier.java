package lidlapp.models;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Courier {
    private Courier() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String pickUpLocation;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private DateTime eta;

    public Long getId() {
        return id;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getStatus() {
        return status;
    }

    public DateTime getEta() {
        return eta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEta(DateTime eta) {
        this.eta = eta;
    }
}
