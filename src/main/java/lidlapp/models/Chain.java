package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Chain implements Serializable {
    private Chain(){
    }
    
    public Chain(String name, String iconUrl, String siteUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.siteUrl = siteUrl;
    }
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String iconUrl;

    @Column(nullable = false)
    private String siteUrl;
    
    @OneToMany
    private Set<Product> products;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getIconUrl() {
        return iconUrl;
    }
    
    public String getSiteUrl() {
        return siteUrl;
    }
    
    public Set<Product> getProducts() {
        return products;
    }
}
