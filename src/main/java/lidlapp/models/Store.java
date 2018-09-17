package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Store implements Serializable {
    private Store() {
    }
    
    public Store(String name, String location, Chain chain) {
        this.name = name;
        this.location = location;
        this.chain = chain;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String location;
    
    @ManyToOne(optional = false)
    private Chain chain;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getName() {
        return name;
    }
    
    public Chain getChain() {
        return chain;
    }
}


