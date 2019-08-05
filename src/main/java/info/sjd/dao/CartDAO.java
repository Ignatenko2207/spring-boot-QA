package info.sjd.dao;

import info.sjd.entity.Cart;
import info.sjd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUser(User user);
}
