package info.sjd.service;

import info.sjd.dao.CartDAO;
import info.sjd.entity.Cart;
import info.sjd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartDAO cartDAO;

    public Cart save(Cart cart){
        if (cartDAO.findById(cart.getId()) == null){
            return cartDAO.save(cart);
        }
        return null;
    }

    public Cart update(Cart cart){
        if (cartDAO.findById(cart.getId()) != null){
            return cartDAO.save(cart);
        }
        return null;
    }

    public Cart findById(Integer id){
        return cartDAO.findById(id).get();
    }

    public List<Cart> findAllByUser(User user){
        return cartDAO.findAllByUser(user);
    }

    public void deleteById(Integer id){
        cartDAO.deleteById(id);
    }
}
