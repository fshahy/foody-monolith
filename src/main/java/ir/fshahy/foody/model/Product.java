package ir.fshahy.foody.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank
	@Size(min = 3, max = 255)
	protected String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	protected ProductCategory category;
}
