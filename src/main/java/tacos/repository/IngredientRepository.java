package tacos.repository;


import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

//CrudRepository first parameter is entity being persisted and second is id type
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
