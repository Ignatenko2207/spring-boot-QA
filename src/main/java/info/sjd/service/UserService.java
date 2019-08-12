package info.sjd.service;

import info.sjd.dao.UserDAO;
import info.sjd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User save(User user){
        if (userDAO.findById(user.getId()) == null){
            return userDAO.save(user);
        }
        return null;
    }

    public User update(User user){
        if (userDAO.findById(user.getId()) != null){
            return userDAO.save(user);
        }
        return null;
    }

    public User findById(Integer id){
        return userDAO.findById(id).get();
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public void deleteById(Integer id){
        userDAO.deleteById(id);
    }
}
