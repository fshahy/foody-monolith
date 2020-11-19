package ir.fshahy.foody.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class City {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank
	@Size(min = 2, max = 255)
	protected String name;
	
	@OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
	protected Set<Vendor> vendors = new HashSet<>();
}
