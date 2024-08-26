package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.enums.RatingStars;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class RatingFactoryTest {

    @Test
    @Order(1)
    void buildRating() {
        Orders order = new Orders.Builder()
                .setId(4582648)
                .build();

        RatingStars foodQuality = RatingStars.FIVE;
        RatingStars deliveryQuality = RatingStars.FIVE;

        Rating rating = RatingFactory.buildRating(order, foodQuality, deliveryQuality);
        assertNotNull(rating);
        System.out.println(rating);
    }

    @Test
    @Order(2)
    void testBuildRatingFail() {
        Orders order = new Orders.Builder()
                .setId(4582648)
                .build();

        RatingStars foodQuality = null;
        RatingStars deliveryQuality = RatingStars.FIVE;

        Rating rating = RatingFactory.buildRating(order, foodQuality, deliveryQuality);
        assertNotNull(rating);
        System.out.println(rating);
    }

    @Test
    @Order(3)
    void buildRatingWithId(){
        Orders order = new Orders.Builder()
                .setId(57257287)
                .build();

        RatingStars foodQuality = RatingStars.FIVE;
        RatingStars deliveryQuality = RatingStars.FOUR;

        Rating rating = RatingFactory.buildRating(894874534L, order, foodQuality, deliveryQuality);
        assertNotNull(rating);
        System.out.println(rating);
    }

    @Test
    @Order(4)
    void testBuildRatingWithIdFail(){
        Orders order = new Orders.Builder()
                .setId(57257287)
                .build();

        RatingStars foodQuality = RatingStars.FIVE;
        RatingStars deliveryQuality = RatingStars.FIVE;

        Rating rating = RatingFactory.buildRating(-894874534L, order, foodQuality, deliveryQuality);
        assertNotNull(rating);
        System.out.println(rating);
    }
}