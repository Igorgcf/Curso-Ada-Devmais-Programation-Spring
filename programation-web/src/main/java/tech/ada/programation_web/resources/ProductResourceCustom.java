package tech.ada.programation_web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.programation_web.dtos.ProductDTO;
import tech.ada.programation_web.services.ProductServiceCustom;

import java.util.List;

@RestController
@RequestMapping("/products/custom")
public class ProductResourceCustom {

    @Autowired
    private ProductServiceCustom service;

    @GetMapping(value = "/d/{description}")
    public ResponseEntity<List<ProductDTO>> findByDescription(@PathVariable String description){

        List<ProductDTO> list = service.findAllByDescription(description);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/de/{description}")
    public ResponseEntity<List<ProductDTO>> findAllByDescriptionContaining(@PathVariable String description){

        List<ProductDTO> list = service.findAllByDescriptionContaining(description);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/des/{description}")
    public ResponseEntity<List<ProductDTO>> findAllByDescriptionStartingWith(@PathVariable String description){

        List<ProductDTO> list = service.findAllByDescriptionStartingWith(description);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/p/{price}")
    public ResponseEntity<List<ProductDTO>> findAllByPriceGreaterThan(@PathVariable Double price){

        List<ProductDTO> list = service.findAllByPriceGreaterThan(price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/pr/{price}")
    public ResponseEntity<List<ProductDTO>> findAllByPriceLessThan(@PathVariable Double price){

        List<ProductDTO> list = service.findAllByPriceLessThan(price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/pri/{min}/{max}")
    public ResponseEntity<List<ProductDTO>> findAllByPriceBetween(@PathVariable Double min, @PathVariable Double max ){

        List<ProductDTO> list = service.findAllByPriceBetween(min, max);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/d/p/{description}/{price}")
    public ResponseEntity<List<ProductDTO>> findAllByDescriptionAndPriceLessThan(@PathVariable String description, @PathVariable Double price){

        List<ProductDTO> list = service.findAllByDescriptionAndPriceLessThan(description, price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/de/pr/{description}/{price}")
    public ResponseEntity<List<ProductDTO>> findAllByDescriptionAndPriceGreaterThan(@PathVariable String description, @PathVariable Double price){

        List<ProductDTO> list = service.findAllByDescriptionAndPriceGreaterThan(description, price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/first/five/min/{price}")
    public ResponseEntity<List<ProductDTO>> findFirstFiveByPriceLessThan(@PathVariable Double price){

        List<ProductDTO> list = service.findAllFirstFiveByPriceLessThan(price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/first/five/max/{price}")
    public ResponseEntity<List<ProductDTO>> findFirstFiveByPriceGreaterThan(@PathVariable Double price){

        List<ProductDTO> list = service.findAllFirstFiveByPriceGreaterThan(price);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/descr/{description}")
    public ResponseEntity<List<ProductDTO>> findAllByDescriptionContainingIgnoreCase(@PathVariable String description){

        List<ProductDTO> list = service.findAllByDescriptionContainingIgnoreCase(description);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/between/{min}/{max}")
    public ResponseEntity<List<ProductDTO>> findAllProductsByPriceBetween(@PathVariable Double min, @PathVariable Double max){

        List<ProductDTO> list = service.findAllProductsByPriceBetween(min, max);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/count/{price}")
    public ResponseEntity<Long> countProducts(@PathVariable Double price){

        Long count = service.countAllByPriceGreaterThan(price);
        return ResponseEntity.ok().body(count);
    }

    @GetMapping(value = "/exists/{name}")
    public ResponseEntity<Boolean> existsProduct(@PathVariable String name){

        Boolean exists = service.existsByName(name);
        return ResponseEntity.ok().body(exists);
    }
}
