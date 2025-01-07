package az.developia.comp_shop_Kanan_Alizade.repository;


import az.developia.comp_shop_Kanan_Alizade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	void save(org.apache.catalina.User user);
}
