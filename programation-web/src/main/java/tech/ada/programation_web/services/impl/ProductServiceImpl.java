package tech.ada.programation_web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ada.programation_web.dtos.ProductDTO;
import tech.ada.programation_web.entities.Product;
import tech.ada.programation_web.repositories.ProductRepository;
import tech.ada.programation_web.services.ProductService;
import tech.ada.programation_web.services.exceptions.ResourceNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<ProductDTO> findAllPaged(Pageable pageable) {

        Page<Product> page = repository.findAll(pageable);
        return page.map((ProductDTO::new));
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDTO findById(UUID id) {

        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product not found, Id: " + id));
        return new ProductDTO(entity);
    }

    @Transactional
    @Override
    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        copyDtoToEntity(entity, dto);
        repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    @Override
    public ProductDTO update(UUID id, ProductDTO dto) {

        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product not found, Id: " + id));
        copyDtoToEntity(entity, dto);
        repository.save(entity);
        return new ProductDTO(entity);
    }

    @Override
    public void delete(UUID id) {

        Optional<Product> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new ResourceNotFoundException("Product not found, Id: " + id);
        }
        repository.deleteById(id);
    }

    void copyDtoToEntity(Product entity, ProductDTO dto){

        if(dto.getName() != null){
            entity.setName(dto.getName());
        } else{
            entity.setName(entity.getName());
        }

        if(dto.getPrice() != null){
            entity.setPrice(dto.getPrice());
        } else {
            entity.setPrice(entity.getPrice());
        }

        if(dto.getDescription() != null){
            entity.setDescription(dto.getDescription());
        } else {
            entity.setDescription(entity.getDescription());
        }

        if(dto.getImage() != null){
            entity.setImage(dto.getImage());
        } else {
            entity.setImage(entity.getImage());
        }
    }
}
