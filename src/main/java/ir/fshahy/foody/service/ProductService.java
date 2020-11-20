package ir.fshahy.foody.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.fshahy.foody.model.Product;
import ir.fshahy.foody.model.ProductCategory;
import ir.fshahy.foody.repository.ProductCategoryRepository;
import ir.fshahy.foody.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductCategoryRepository categoryRepo;
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepo.findById(id);
	}
	
	public Product addProduct(Product product) {
		if(productRepo.existsProductByName(product.getName())) {
			return productRepo.getProductByName(product.getName());
		}
		
		return productRepo.save(product);
	}
	
	public List<ProductCategory> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	public ProductCategory addProductCategory(ProductCategory category) {
		return categoryRepo.save(category);
	}
	
	public Optional<ProductCategory> getProductCategoryById(Long id) {
		return categoryRepo.findById(id);
	}
}
