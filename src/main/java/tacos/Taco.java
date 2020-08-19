package tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    //Automatically have the database generate an ID for the taco
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Make sure name isn't null
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    //One taco can have many ingredients and one ingredient can be in many different tacos
    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You need to have at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
