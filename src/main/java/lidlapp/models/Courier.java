package lidlapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Courier implements Serializable {
    public Courier() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String pickUpLocation;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date eta;

    public Long getId() {
        return id;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getStatus() {
        return status;
    }

    public Date getEta() {
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

    public void setEta(Date eta) {
        this.eta = eta;
    }
}
