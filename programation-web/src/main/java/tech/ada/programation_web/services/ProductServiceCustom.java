package tech.ada.programation_web.services;

import tech.ada.programation_web.dtos.ProductDTO;

import java.util.List;

public interface ProductServiceCustom {

    List<ProductDTO> findAllByDescription(String description);
    List<ProductDTO> findAllByDescriptionContaining(String description);
    List<ProductDTO> findAllByDescriptionStartingWith(String description);

    List<ProductDTO> findAllByPriceGreaterThan(Double price);
    List<ProductDTO> findAllByPriceLessThan(Double price);
    List<ProductDTO> findAllByPriceBetween(Double min, Double max);

    List<ProductDTO> findAllByDescriptionAndPriceLessThan(String description, Double price);
    List<ProductDTO> findAllByDescriptionAndPriceGreaterThan(String description, Double price);

    List<ProductDTO> findAllFirstFiveByPriceLessThan(Double price);
    List<ProductDTO> findAllFirstFiveByPriceGreaterThan(Double price);

    List<ProductDTO> findAllByDescriptionContainingIgnoreCase(String description);
    List<ProductDTO> findAllProductsByPriceBetween(Double min, Double max);

    Long countAllByPriceGreaterThan(Double price);
    Boolean existsByName(String name);
}
