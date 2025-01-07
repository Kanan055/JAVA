package az.developia.comp_shop_Kanan_Alizade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.comp_shop_Kanan_Alizade.model.Order;
import az.developia.comp_shop_Kanan_Alizade.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}