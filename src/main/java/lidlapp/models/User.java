package lidlapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {
    public User() {
    }

    public User(String email, String nickname, String id) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    @Id
    private String id;

    @Column(nullable = false)
    private String email;

    private String nickname;

    private String iban;

    private String name;

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    private Set<OrderItem> orders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OrderItem> getOrders() {
        return orders;
    }

    public void addOrder(Courier courier, String product) {
        orders.add(new OrderItem(product, courier, this));
    }
}
