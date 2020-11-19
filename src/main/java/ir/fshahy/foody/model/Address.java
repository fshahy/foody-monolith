package ir.fshahy.foody.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {
	@NotBlank
	protected String line1;
	protected String line2;
}
