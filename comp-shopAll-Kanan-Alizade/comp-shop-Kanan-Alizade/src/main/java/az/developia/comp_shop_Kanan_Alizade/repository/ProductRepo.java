package az.developia.comp_shop_Kanan_Alizade.repository;


	import az.developia.comp_shop_Kanan_Alizade.model.Product;
	import az.developia.comp_shop_Kanan_Alizade.model.User;
	import org.springframework.data.jpa.repository.JpaRepository;

	import java.util.List;

	public interface ProductRepo extends JpaRepository<Product, Long> {
	    List<Product> findBySeller(User seller);
	}

