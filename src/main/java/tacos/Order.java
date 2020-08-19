package tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotNull(message="Name is required")
    private String deliveryName;

    @NotNull(message="Street is required")
    private String deliveryStreet;

    @NotNull(message="City is required")
    private String deliveryCity;

    @NotNull(message="State is required")
    private String deliveryState;

    @NotNull(message="Zip code is required")
    private String deliveryZip;

    @Pattern(regexp="[0-9]{16}", message="Enter CC # with no spaces")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Format must be MM/YY")
    private String ccExpiration;

    @Pattern(regexp="[0-9]{3}", message="Invalid CCV")
    private String ccCVV;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
