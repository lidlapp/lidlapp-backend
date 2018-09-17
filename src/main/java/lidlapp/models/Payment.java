package lidlapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {
    private Payment() {
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tikkieLink;

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTikkieLink() {
        return tikkieLink;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTikkieLink(String tikkieLink) {
        this.tikkieLink = tikkieLink;
    }
}
