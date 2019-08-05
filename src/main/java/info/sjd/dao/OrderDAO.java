package info.sjd.dao;

import info.sjd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query( nativeQuery = true,
            value = "SELECT * FROM orders o JOIN carts c ON o.cart_id=c.id WHERE c.time>?1 AND c.time<?2")
    List<Order> findAllByTime(Long timeFrom, Long timeTo);
}
