package ir.fshahy.foody.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class ProductCategory {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank
	@Size(min = 3, max = 255)
	protected String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	protected ProductCategory parent;
	
	@OneToMany(mappedBy = "category")
	protected Set<Product> products;
}
