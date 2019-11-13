package de.mysiteweb.dao;

import de.mysiteweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by PC-2 on 29.09.2019.
 */
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource (path= "/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    @RestResource (path="/productsByKeyword")
    public List<Product> findByNameContains (@Param("mc") String mc);
}