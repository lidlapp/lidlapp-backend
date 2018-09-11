package lidlapp.models;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chain {
    private Chain(){
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String iconUrl;

    @Column(nullable = false)
    private DateTime siteUrl;
}
