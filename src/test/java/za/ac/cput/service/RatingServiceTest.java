package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.enums.RatingStars;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.RatingFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class RatingServiceTest {

    @Autowired
    private RatingService ratingService;

    private Orders  order;
    private  Rating rating;

    @BeforeEach
    void a_setUp() {

        order = new Orders.Builder().setId(100L).build();
        RatingStars foodQuality = RatingStars.FIVE;
        RatingStars deliveryQuality = RatingStars.FIVE;
        rating = RatingFactory.buildRating(48L, order, foodQuality, deliveryQuality);

    }

    @Test
    void b_save() {
        Rating savedRating = ratingService.save(rating);
        assertNotNull(savedRating);
        System.out.println(savedRating);

    }

    @Test
    void c_read() {
        Rating read = ratingService.read(48L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Rating updatedRating = new Rating.Builder().copy(rating).setFoodQuality(RatingStars.FOUR).build();
        Rating savedUpdatedRating = ratingService.update(updatedRating);

        assertNotNull(savedUpdatedRating);
        System.out.println(savedUpdatedRating);
    }

    @Test
    @Disabled
    void f_delete() {
        ratingService.delete(rating.getId());
        System.out.println("rating successfully deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(ratingService.getAll());
    }
}