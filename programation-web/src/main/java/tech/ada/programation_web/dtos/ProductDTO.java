package tech.ada.programation_web.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.ada.programation_web.entities.Product;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private UUID id;
    private String name;
    private Double price;
    private String description;
    private String image;


    public ProductDTO(Product entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.image = entity.getImage();
    }
}
