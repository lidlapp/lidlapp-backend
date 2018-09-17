package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem implements Serializable {
    private OrderItem() {
    }
    
    public OrderItem(Product product, Integer amount, BigDecimal actualPrice) {
        this.product = product;
        this.amount = amount;
        this.actualPrice = actualPrice;
        this.accepted = false;
        this.outOfStock = false;
    }
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Product product;
    
    @OneToMany
    private Payment payment;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private BigDecimal actualPrice;

    @Column(nullable = false)
    private boolean accepted;

    @Column(nullable = false)
    private boolean outOfStock;
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }
    
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }
    
    public Long getId() {
        return id;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
    public BigDecimal getActualPrice() {
        return actualPrice;
    }
    
    public boolean isAccepted() {
        return accepted;
    }
    
    public boolean isOutOfStock() {
        return outOfStock;
    }
}
