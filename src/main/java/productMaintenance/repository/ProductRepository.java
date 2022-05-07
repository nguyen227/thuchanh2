package productMaintenance.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import productMaintenance.model.Product;

public interface ProductRepository extends CrudRepository<Product, String>{
	
	@Query("SELECT * FROM PRODUCT P WHERE P.CODE = $1")
	Product findByCode(String code);
	
	@Query("DELETE FROM PRODUCT WHERE PRODUCT.CODE = '$1'")
	void deleteByCode(String code);
}
