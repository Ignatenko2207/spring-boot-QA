package info.sjd.service;

import info.sjd.dao.OrderDAO;
import info.sjd.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    public Order save(Order cart){
        if (orderDAO.findById(cart.getId()) == null){
            return orderDAO.save(cart);
        }
        return null;
    }

    public Order update(Order cart){
        if (orderDAO.findById(cart.getId()) != null){
            return orderDAO.save(cart);
        }
        return null;
    }

    public Order findById(Integer id){
        return orderDAO.findById(id).get();
    }

    public List<Order> findAllByTime(Long timeFrom, Long timeTo){
        return orderDAO.findAllByTime(timeFrom, timeTo);
    }

    public void deleteById(Integer id){
        orderDAO.deleteById(id);
    }
}
