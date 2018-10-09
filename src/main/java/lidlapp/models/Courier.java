package lidlapp.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Courier implements Serializable {
    public Courier() {
    }
    
    public Courier(User user, Store store, String pickUpLocation, Date eta) {
        this.user = user;
        this.store = store;
        this.payments = null;
        this.pickUpLocation = pickUpLocation;
        this.status = CourierStatus.NOT_DEPPARTED;
        this.eta = eta;
    }
    
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "courier")
    private Set<OrderItem> orderItems;

    @JsonIgnore
    @ManyToOne(optional = false)
    private User user;

    @JsonGetter
    public String getNickname() {
        return user.getNickname();
    }

    @JsonIgnore
    @ManyToOne(optional = false)
    private Store store;

    @JsonGetter
    public long getStoreId() {
        return store.getId();
    }
    
    @OneToMany
    private Set<Payment> payments;

    @Column(nullable = false)
    private String pickUpLocation;

    @Column(nullable = false)
    private CourierStatus status;

    @Column(nullable = false)
    private Date eta;

    public Long getId() {
        return id;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public User getUser() {
        return user;
    }
    
    public Store getStore() {
        return store;
    }
    
    public Set<Payment> getPayments() {
        return payments;
    }
    
    public String getPickUpLocation() {
        return pickUpLocation;
    }
    
    public CourierStatus getStatus() {
        return status;
    }
    
    public Date getEta() {
        return eta;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }
    
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }
    
    public void setStatus(CourierStatus status) {
        this.status = status;
    }
    
    public void setEta(Date eta) {
        this.eta = eta;
    }
}
