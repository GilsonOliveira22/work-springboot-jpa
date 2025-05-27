package com.aprimorapring.aprimora.config;

import java.math.BigDecimal;

import com.aprimorapring.aprimora.entities.Category;
import com.aprimorapring.aprimora.entities.Order;
import com.aprimorapring.aprimora.entities.Product;
import com.aprimorapring.aprimora.entities.User;
import com.aprimorapring.aprimora.entities.enums.OrderStatus;
import com.aprimorapring.aprimora.repositories.CategoryRepository;
import com.aprimorapring.aprimora.repositories.OrderRepository;
import com.aprimorapring.aprimora.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

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

        Product p1 = new Product().builder()
                .id(null)
                .tipo("The Lord of the Rings")
                .nome("Lorem ipsum dolor sit amet, consectetur.")
                .valor(new BigDecimal("90.5"))
                .descricao("")
                .build();

        Product p2 = new Product().builder()
                .id(null)
                .tipo("Smart TV")
                .nome("Nulla eu imperdiet purus. Maecenas ante.")
                .valor(new BigDecimal("2190.0"))
                .descricao("")
                .build();

        Product p3 = new Product().builder()
                .id(null)
                .tipo("Macbook Pro")
                .nome("Nam eleifend maximus tortor, at mollis.")
                .valor(new BigDecimal("1250.0"))
                .descricao("")
                .build();

        Product p4 = new Product().builder()
                .id(null)
                .tipo("PC Gamer")
                .nome("Donec aliquet odio ac rhoncus cursus.")
                .valor(new BigDecimal("1200.0"))
                .descricao("")
                .build();

        Product p5 = new Product().builder()
                .id(null)
                .tipo("Rails for Dummies")
                .nome("Cras fringilla convallis sem vel faucibus.")
                .valor(new BigDecimal("100.99"))
                .descricao("")
                .build();

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
