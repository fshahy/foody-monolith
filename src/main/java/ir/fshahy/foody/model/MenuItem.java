package ir.fshahy.foody.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class MenuItem {
	@Id
	@GeneratedValue
	protected Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	protected Menu menu;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	protected Product product;
	
	@NotNull
	protected BigDecimal price;
}
