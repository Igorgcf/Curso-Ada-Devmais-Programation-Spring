package tech.ada.programation_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.programation_web.entities.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    //Métodos que filtram produtos com base no campo 'description'.
    List<Product> findAllByDescription(String description);
    List<Product> findAllByDescriptionContaining(String description);
    List<Product> findAllByDescriptionStartingWith(String description);

    //Métodos que filtram produtos utilizando comparação com campos numéricos.
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product> findAllByPriceLessThan(Double price);
    List<Product> findAllByPriceBetween(Double min, Double max);

    //Métodos que filtram produtos com múltiplas condições.
    List<Product> findAllByDescriptionAndPriceLessThan(String description, Double price);
    List<Product> findAllByDescriptionAndPriceGreaterThan(String description, Double price);

    //Métodos que retornam os primeiros 5 produtos (limitar resultados) com o menor e maior preço.
    List<Product> findAllFirstFiveByPriceGreaterThan(Double price);
    List<Product> findAllFirstFiveByPriceLessThan(Double price);

    //Métodos com query JPQL personalizada.
    @Query("SELECT p FROM Product p WHERE p.description LIKE %:description%")
    List<Product> findAllByDescriptionContainingIgnoreCase(String description);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findAllProductsByPriceBetween(Double min, Double max);

    //Métodos que retornam contagem e existência de produtos.
    Long countAllByPriceGreaterThan(Double price);
    Boolean existsByName(String name);
}
