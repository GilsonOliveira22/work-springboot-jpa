package com.aprimorapring.aprimora.config;

import com.aprimorapring.aprimora.entities.Category;
import com.aprimorapring.aprimora.entities.Order;
import com.aprimorapring.aprimora.entities.User;
import com.aprimorapring.aprimora.entities.enums.OrderStatus;
import com.aprimorapring.aprimora.repositories.CategoryRepository;
import com.aprimorapring.aprimora.repositories.OrderRepository;
import com.aprimorapring.aprimora.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {

        User u1 = new User().builder()
                .id(null)
                .name("Maria Brown")
                .email("maria@gmail.com")
                .phone("988888888")
                .password("123456")
                .build();

        User u2 = new User().builder()
                .id(null)
                .name("Alex Green")
                .email("alex@gmail.com")
                .phone("977777777")
                .password("123456")
                .build();

        userRepository.saveAll(Arrays.asList(u1, u2));


        Order o1 = new Order().builder()
                .id(null)
                .moment(Instant.parse("2019-06-20T19:53:07Z"))
                .client(u1)
                .orderStatus(OrderStatus.WAITING_PAYMENT.getCode())
                .build();

        Order o2 = new Order().builder()
                .id(null)
                .moment(Instant.parse("2019-07-21T03:42:10Z"))
                .client(u2)
                .orderStatus(OrderStatus.PAID.getCode())
                .build();

        Order o3 = new Order().builder()
                .id(null)
                .moment(Instant.parse("2019-07-22T15:21:22Z"))
                .client(u1)
                .orderStatus(OrderStatus.SHIPPED.getCode())
                .build();

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category().builder()
                .id(null)
                .name("Electronics")
                .build();

        Category cat2 = new Category().builder()
                .id(null)
                .name("Books")
                .build();

        Category cat3 = new Category().builder()
                .id(null)
                .name("Computers")
                .build();

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
