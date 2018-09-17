package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem implements Serializable {
    private OrderItem() {
    }

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private Product product;
    
    private Payment payment;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private BigDecimal actualPrice;

    @Column(nullable = false)
    private boolean accepted;

    @Column(nullable = false)
    private boolean outOfStock;


}
