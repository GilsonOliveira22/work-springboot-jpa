package com.aprimorapring.aprimora.config;

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

        Product p1 = new Product().builder()
                .id(null)
                .name("The Lord of the Rings")
                .description("Lorem ipsum dolor sit amet, consectetur.")
                .price(90.5)
                .imgUrl("")
                .build();

        Product p2 = new Product().builder()
                .id(null)
                .name("Smart TV")
                .description("Nulla eu imperdiet purus. Maecenas ante.")
                .price(2190.0)
                .imgUrl("")
                .build();

        Product p3 = new Product().builder()
                .id(null)
                .name("Macbook Pro")
                .description("Nam eleifend maximus tortor, at mollis.")
                .price(1250.0)
                .imgUrl("")
                .build();

        Product p4 = new Product().builder()
                .id(null)
                .name("PC Gamer")
                .description("Donec aliquet odio ac rhoncus cursus.")
                .price(1200.0)
                .imgUrl("")
                .build();

        Product p5 = new Product().builder()
                .id(null)
                .name("Rails for Dummies")
                .description("Cras fringilla convallis sem vel faucibus.")
                .price(100.99)
                .imgUrl("")
                .build();
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

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
    }
}
