package productMaintenance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Data
public class Product {

	@Id
	private String code;
	
	private String description;

	private double price;
	
	
	public Product() {
		super();
		
		this.code = "";
		this.description = "";
		this.price = 0;
	}
	
	
}
