package tech.ada.programation_web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.ada.programation_web.dtos.ProductDTO;

import java.util.UUID;

public interface ProductService {

    Page<ProductDTO> findAllPaged(Pageable pageable);

    ProductDTO findById(UUID id);

    ProductDTO insert(ProductDTO dto);

    ProductDTO update(UUID id, ProductDTO dto);

    void delete(UUID id);
}
