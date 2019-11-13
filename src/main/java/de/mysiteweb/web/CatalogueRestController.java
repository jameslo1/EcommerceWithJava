package de.mysiteweb.web;

import de.mysiteweb.dao.ProductRepository;
import de.mysiteweb.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by PC-2 on 03.10.2019.
 */
@RestController
public class CatalogueRestController {

    private ProductRepository productRepository;


    public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /*
    @Autowired
    private ProductRepository productRepository;
    */
    @GetMapping(path="/photoProduct/{id}", produces= MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecommerce/products/"+p.getPhotoname()));

    }
}
