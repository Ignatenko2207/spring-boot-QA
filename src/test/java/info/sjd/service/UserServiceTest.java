package info.sjd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import info.sjd.ApplicationRunner;
import info.sjd.dao.UserDAO;
import info.sjd.entity.Profile;
import info.sjd.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

@SpringJUnitConfig(ApplicationRunner.class)
@SpringBootTest
class UserServiceTest {

    @MockBean
    UserDAO userDAO;

    @Autowired
    UserService userService;

    @Test
    void save() {
        User user = new User("t_login", "t_pass", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);

        User storedUser = new User( 1,"t_login", "t_pass", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);

        when(userDAO.save(user)).thenReturn(storedUser);

        User savedUser = userService.save(user);
        assertNotNull(savedUser);

        verify(userDAO, times(1)).save(any(User.class));
    }

    @Test
    void update() {
        User user = new User(1,"t_login", "t_pass", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);

        User updatedUser = new User( 1,"ignatenko", "12345", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);

        when(userDAO.findById(user.getId())).thenReturn(Optional.of(user));
        when(userDAO.save(user)).thenReturn(updatedUser);

        User savedUser = userService.update(user);
        assertNotNull(savedUser);

        verify(userDAO, times(1)).findById(user.getId());
        verify(userDAO, times(1)).save(any(User.class));
    }

}