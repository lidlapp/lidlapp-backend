package lidlapp.models;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Courier implements Serializable {
    public Courier() {
    }
    
    public Courier(User user, Store store, String pickUpLocation, Date eta) {
        this.orderItems = null;
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
    
    @OneToMany
    private Set<OrderItem> orderItems;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Store store;
    
    @OneToMany
    private Set<Payment> payments;

    @Column(nullable = false)
    private String pickUpLocation;

    @Column(nullable = false)
    private CourierStatus status;

    @Column(nullable = false)
    private Date eta;
}
