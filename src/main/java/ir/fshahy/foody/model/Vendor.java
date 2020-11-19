package ir.fshahy.foody.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
//@Table(name = "vendors")
public class Vendor {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank
	@Size(min = 3, max = 255)
	protected String name;
	
	protected String email;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	protected City city;
	
	protected Address address;
	
	@OneToOne(mappedBy = "vendor")
	protected Menu menu;
}
