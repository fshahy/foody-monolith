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

import ir.fshahy.foody.model.Menu;
import ir.fshahy.foody.model.MenuItem;
import ir.fshahy.foody.model.Vendor;
import ir.fshahy.foody.service.VendorService;

@RestController
@RequestMapping("${foody.api.base.path}/${foody.api.version}/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;;

	@GetMapping
	public ResponseEntity<List<Vendor>> getAllVendors() {
		return ResponseEntity.ok().body(vendorService.getAllVendors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
		return vendorService.getVendorById(id)
				.map(vendor -> {
					return ResponseEntity.ok().body(vendor);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok().body(vendorService.addVendor(vendor));
	}
	
	@GetMapping("/{vendorId}/menu")
	public ResponseEntity<Menu> getMenu(@PathVariable Long vendorId) {
		return ResponseEntity.ok().body(vendorService.getMenu(vendorId));
	}
	
	@PostMapping("/{vendorId}/menu")
	public ResponseEntity<Menu> createMenu(@PathVariable Long vendorId) {
		return ResponseEntity.ok().body(vendorService.addMenu(vendorId));
	}
	
	@PostMapping("/{vendorId}/menu/item")
	public ResponseEntity<MenuItem> createItem(@PathVariable Long vendorId, @RequestBody MenuItem item) {
		return ResponseEntity.ok().body(vendorService.addItem(vendorId, item));
	}
	
	@GetMapping("/{vendorId}/menu/item/{itemId}")
	public ResponseEntity<MenuItem> getItemById(@PathVariable Long itemId) {
		return vendorService.getItemById(itemId).map(item -> {
			return ResponseEntity.ok().body(item);
		})
		.orElse(ResponseEntity.notFound().build());
	}
}
