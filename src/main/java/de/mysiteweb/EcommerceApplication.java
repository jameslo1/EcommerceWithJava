package de.mysiteweb;

import de.mysiteweb.dao.CategoryRepository;
import de.mysiteweb.dao.ProductRepository;
import de.mysiteweb.entities.Category;
import de.mysiteweb.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
		categoryRepository.save(new Category(null,"Laptops",null,null,null));
		categoryRepository.save(new Category(null,"Printers",null,null,null));
		categoryRepository.save(new Category(null,"Phones",null,null,null));

		Random rnd=new Random();

		categoryRepository.findAll().forEach(c->{
			for (int i =0; i<10;i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentprice(100 + rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoname("unknown.png");
				productRepository.save(p);
			}
		});


	}
}
