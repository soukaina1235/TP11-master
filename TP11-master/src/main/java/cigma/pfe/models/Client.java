package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Inherited;
import java.util.List;

@Getter
@Setter
@Entity(name = "TClients")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "client_type")
@DiscriminatorValue("client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "Nom")
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE},mappedBy = "client")
    private List<Facture> factures;
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "my_join_table_client_promotion",joinColumns = @JoinColumn(
            name = "client_fk",referencedColumnName = "id"
    ),
    inverseJoinColumns = @JoinColumn(
            name = "promotion_fk",
            referencedColumnName = "id"
    )
    )
    private List<Promotion> promotions;
    @OneToOne(cascade = {CascadeType.MERGE},mappedBy = "client")
    private CarteFidelio carteFidelio;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }
}
