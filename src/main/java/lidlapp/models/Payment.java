package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Payment implements Serializable {
    private Payment() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tikkieLink;

    @OneToMany
    private Set<OrderItem> items;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTikkieLink() {
        return tikkieLink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTikkieLink(String tikkieLink) {
        this.tikkieLink = tikkieLink;
    }
}
