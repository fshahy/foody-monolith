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

import ir.fshahy.foody.model.ProductCategory;
import ir.fshahy.foody.service.ProductService;

@RestController
@RequestMapping("${foody.api.base.path}/${foody.api.version}/category")
public class ProductCategoryController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductCategory>> getAll() {
		return ResponseEntity.ok().body(this.productService.getAllCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCategory> getCategoryById(@PathVariable Long id) {
		return this.productService.getProductCategoryById(id)
			.map(category -> {
				return ResponseEntity.ok().body(category);
			})
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ProductCategory addCategory(@RequestBody ProductCategory category) {
		return this.productService.addProductCategory(category);
	}
}
