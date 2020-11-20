package ir.fshahy.foody.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(nullable = false)
	protected String line1;
	
	@Column
	protected String line2;
}
