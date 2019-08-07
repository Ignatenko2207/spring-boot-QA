package info.sjd.dao;

import info.sjd.ApplicationRunner;
import info.sjd.entity.*;
import info.sjd.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDAOTest {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    OrderDAO orderDAO;

    List<User> users = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    List<Cart> carts = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    @BeforeEach
    void setUp() {
        User user = new User("t_login", "t_pass", "t_email", "t_f_name", "t_l_name", Profile.CLIENT);
        User savedUser = userDAO.save(user);
        users.add(savedUser);

        Item item = new Item("t_art", "t_name", 12345, 15432);
        Item savedItem = itemDAO.save(item);
        items.add(savedItem);

        Cart cart = new Cart(new Date().getTime(), savedUser, Status.OPEN);
        Cart savedCart = cartDAO.save(cart);
        carts.add(savedCart);

        Order order = new Order(savedItem, 10, savedCart);
        Order savedOrder = orderDAO.save(order);
        orders.add(savedOrder);
    }

    @AfterEach
    void tearDown() {
        orders.stream().forEach(order -> orderDAO.delete(order));
        carts.stream().forEach(cart -> cartDAO.delete(cart));
        items.stream().forEach(item -> itemDAO.delete(item));
        users.stream().forEach(user -> userDAO.delete(user));
    }

    @Test
    void findAllByTime() {
        Long from = new Date().getTime() - 10_000;
        Long to = new Date().getTime() + 10_000;
        List<Order> orders = orderDAO.findAllByTime(from, to);
        assertNotNull(orders);
        assertTrue(!orders.isEmpty());
        assertEquals(items.get(0).getArticle(), orders.get(0).getItem().getArticle());
    }
}