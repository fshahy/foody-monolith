package ir.fshahy.foody.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"items", "hibernateLazyInitializer"})
public class Menu {
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	protected Vendor vendor;
	
	@OneToMany(mappedBy = "menu")
	protected Set<MenuItem> items;
}
