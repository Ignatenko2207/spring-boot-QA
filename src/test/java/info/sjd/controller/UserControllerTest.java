package info.sjd.controller;

import info.sjd.ApplicationRunner;
import info.sjd.entity.Profile;
import info.sjd.entity.User;
import info.sjd.service.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
class UserControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @MockBean
    UserService userService;

    @Test
    void save() {

    }

//    @Test
    void findById() throws URISyntaxException {
        RequestEntity request = new RequestEntity(HttpMethod.GET, new URI("/user/find/1"));

        User user = new User(1,"t_login", "t_pass", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);
        when(userService.findById(user.getId())).thenReturn(user);

        ResponseEntity<User> response = testRestTemplate.exchange(request, User.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        verify(userService, times(1)).findById(user.getId());
    }

//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
}