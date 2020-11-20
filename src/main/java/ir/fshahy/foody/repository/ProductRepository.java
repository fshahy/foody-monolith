package ir.fshahy.foody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.fshahy.foody.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	boolean existsProductByName(String productName);
	Product getProductByName(String productName);
}
