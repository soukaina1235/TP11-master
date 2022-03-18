package cigma.pfe.models;


import com.sun.jdi.event.ClassUnloadEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Data

@NoArgsConstructor

public class ClientNormal extends Client {
    private int importanceLevel;

    public ClientNormal(String name, int importanceLevel) {
        super(name);
        this.importanceLevel = importanceLevel;
    }
}
