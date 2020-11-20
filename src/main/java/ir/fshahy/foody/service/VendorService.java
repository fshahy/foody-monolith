package ir.fshahy.foody.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.fshahy.foody.model.Menu;
import ir.fshahy.foody.model.MenuItem;
import ir.fshahy.foody.model.Vendor;
import ir.fshahy.foody.repository.MenuItemRepository;
import ir.fshahy.foody.repository.MenuRepository;
import ir.fshahy.foody.repository.VendorRepository;

@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private MenuItemRepository itemRepo;
	
//	@PersistenceContext
//	private EntityManager em;
	
	public List<Vendor> getAllVendors() {
		return vendorRepo.findAll();
	}
	
	public Optional<Vendor> getVendorById(Long id) {
		return vendorRepo.findById(id);
	}
	
	public Vendor addVendor(Vendor vendor) {
		if(vendorRepo.existsVendorByName(vendor.getName())) {
			return vendorRepo.getVendorByName(vendor.getName());
		}
		
		return vendorRepo.save(vendor);
	}
	
	public Menu getMenu(Long vendorId) {
		if(menuRepo.existsMenuByVendorId(vendorId)) {
			return menuRepo.getMenuByVendorId(vendorId);
		}

		return addMenu(vendorId);
	}
	
	public Menu addMenu(Long vendorId) {
		if(menuRepo.existsMenuByVendorId(vendorId)) {
			return menuRepo.getMenuByVendorId(vendorId);
		}
		
		var vendor = Vendor.builder().id(vendorId).build();
		var menu = Menu.builder().vendor(vendor).build();
		return menuRepo.save(menu);
	}
	
	public MenuItem addItem(Long vendorId, MenuItem item) {
		var vendor = vendorRepo.findById(vendorId);
		var menu = Menu.builder().id(vendor.get().getMenu().getId()).build();
		item.setMenu(menu);
		
		if(vendor.isPresent()) {
			vendor.get().getMenu().getItems().add(item);
			itemRepo.save(item);
		}
		
		return item;
	}
	
	public Optional<MenuItem> getItemById(Long itemId) {
		return itemRepo.findById(itemId);
	}
}
