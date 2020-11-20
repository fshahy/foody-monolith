package ir.fshahy.foody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.fshahy.foody.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
	boolean existsVendorByName(String vendorName);
	Vendor getVendorByName(String vendorName);
}
