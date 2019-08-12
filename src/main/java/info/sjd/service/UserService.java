package info.sjd.service;

import info.sjd.dao.UserDAO;
import info.sjd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User save(User user){
        if (user.getId() == null || userDAO.findById(user.getId()) == null){
            return userDAO.save(user);
        }
        return null;
    }

    public User update(User user){
        if (user.getId() != null && userDAO.findById(user.getId()) != null){
            return userDAO.save(user);
        }
        return null;
    }

    public User findById(Integer id){
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public void deleteById(Integer id){
        userDAO.deleteById(id);
    }
}
