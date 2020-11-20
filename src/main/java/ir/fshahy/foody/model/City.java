package ir.fshahy.foody.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"vendors", "hibernateLazyInitializer"})
public class City {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank
	@Size(min = 2, max = 255)
	protected String name;
	
	@OneToMany(mappedBy = "city")
	protected Set<Vendor> vendors;
}
