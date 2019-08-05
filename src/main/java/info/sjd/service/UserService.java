package info.sjd.service;

import info.sjd.dao.UserDAO;
import info.sjd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void delete(User user){
        userDAO.delete(user);
    }
}
