package lidlapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem implements Serializable {
    private OrderItem() {
    }

    @Id
    @GeneratedValue
    private Long id;

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
