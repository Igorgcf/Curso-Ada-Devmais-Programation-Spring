package tech.ada.programation_web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.programation_web.dtos.ProductDTO;
import tech.ada.programation_web.entities.Product;
import tech.ada.programation_web.repositories.ProductRepository;
import tech.ada.programation_web.services.ProductServiceCustom;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceCustomImpl implements ProductServiceCustom {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductDTO> findAllByDescription(String description) {

        List<Product> list = repository.findAllByDescription(description);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByDescriptionContaining(String description) {

        List<Product> list = repository.findAllByDescriptionContaining(description);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByDescriptionStartingWith(String description) {

        List<Product> list = repository.findAllByDescriptionStartingWith(description);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPriceBetween(Double min, Double max) {

        List<Product> list = repository.findAllByPriceBetween(min, max);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThan(Double price) {

        List<Product> list = repository.findAllByPriceGreaterThan(price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPriceLessThan(Double price) {

        List<Product> list = repository.findAllByPriceLessThan(price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByDescriptionAndPriceLessThan(String description, Double price) {

        List<Product> list = repository.findAllByDescriptionAndPriceLessThan(description, price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByDescriptionAndPriceGreaterThan(String description, Double price) {

        List<Product> list = repository.findAllByDescriptionAndPriceGreaterThan(description, price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllFirstFiveByPriceLessThan(Double price) {

        List<Product> list = repository.findAllFirstFiveByPriceLessThan(price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllFirstFiveByPriceGreaterThan(Double price) {

        List<Product> list = repository.findAllFirstFiveByPriceGreaterThan(price);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByDescriptionContainingIgnoreCase(String description) {

        List<Product> list = repository.findAllByDescriptionContainingIgnoreCase(description);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllProductsByPriceBetween(Double min, Double max) {

        List<Product> list = repository.findAllProductsByPriceBetween(min, max);
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long countAllByPriceGreaterThan(Double price) {
       Long count = repository.countAllByPriceGreaterThan(price);
       return count;
    }

    @Override
    public Boolean existsByName(String name) {

        Boolean exists = repository.existsByName(name);
        return exists;
    }
}
