package ir.fshahy.foody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.fshahy.foody.model.Product;
import ir.fshahy.foody.service.ProductService;

@RestController
@RequestMapping("${foody.api.base.path}/${foody.api.version}/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok().body(this.productService.getAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		return productService.getProductById(id)
			.map(product -> {
				return ResponseEntity.ok().body(product);
			})
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(productService.addProduct(product));
	}
}
