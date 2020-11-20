package ir.fshahy.foody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.fshahy.foody.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	boolean existsMenuByVendorId(Long vendorId);
	Menu getMenuByVendorId(Long vendorId);
}
