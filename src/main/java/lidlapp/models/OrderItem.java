package lidlapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem implements Serializable {
    private OrderItem() {
    }

    public OrderItem(String product, Courier courier, User consumer) {
        this.product = product;
        this.courier = courier;
        this.consumer = consumer;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String product;

    private BigDecimal actualPrice;

    // TODO: 2018-10-17 Consider the use of an enum
    private boolean accepted;

    @Column(nullable = false)
    private boolean outOfStock = false;

    @JsonIgnore
    @ManyToOne
    private User consumer;

    @JsonIgnore
    @ManyToOne
    private Courier courier;

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

    public String getProduct() {
        return product;
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
