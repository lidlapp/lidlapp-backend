package lidlapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrderItem {
    private OrderItem() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private BigDecimal actualPrice;

    @Column(nullable = false)
    private boolean accepted;

    @Column(nullable = false)
    private boolean outOfStock;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

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
}
