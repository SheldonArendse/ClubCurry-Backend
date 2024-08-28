package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.enums.RatingStars;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ReviewFactoryTest {

    @Test
    @Order(1)
    void buildReview() {
        Orders order = new Orders.Builder()
                .setId(4582648)
                .build();

        Rating rating = RatingFactory.buildRating(order, RatingStars.TWO, RatingStars.FOUR,RatingStars.THREE, RatingStars.THREE);

        Customer customer = new Customer.Builder()
                .setEmail("PaulWalker@gmail.com")
                .setName("Paul")
                .setSurname("Walker")
                .setPassword("Paul007")
                .build();

        Review review = ReviewFactory.buildReview(rating, customer,"Excellent service!");
        assertNotNull(review);
        System.out.println(review);


    }

    @Test
    @Order(2)
    void testBuildReviewFail() {
        Orders order = new Orders.Builder()
                .setId(4582648)
                .build();

        Rating rating = RatingFactory.buildRating(order, RatingStars.TWO, RatingStars.FOUR,RatingStars.THREE, RatingStars.THREE);


        Customer customer = new Customer.Builder()
                .setEmail("PaulWalker@gmail.com")
                .setName("Paul")
                .setSurname("Walker")
                .setPassword("Paul007")
                .build();

        Review review = ReviewFactory.buildReview(rating, customer,"");
        assertNotNull(review);
        System.out.println(review);
    }

    @Test
    @Order(3)
    void buildReviewWithId(){
            Orders order = new Orders.Builder()
                    .setId(2225555)
                    .build();

        Rating rating = RatingFactory.buildRating(order, RatingStars.TWO, RatingStars.FOUR,RatingStars.THREE, RatingStars.THREE);

        Customer customer = new Customer.Builder()
                    .setEmail("VinDiesel@gmail.com")
                    .setName("Vin")
                    .setSurname("Diesel")
                    .setPassword("see ya")
                    .build();

            Review review = ReviewFactory.buildReview(54333663L, rating, customer,"Driver took long");
            assertNotNull(review);
            System.out.println(review);
    }

    @Test
    @Order(4)
    void testBuildReviewWithIdFail(){
        Orders order = new Orders.Builder()
                .setId(2225555)
                .build();

        Rating rating = RatingFactory.buildRating(order, RatingStars.TWO, RatingStars.FOUR,RatingStars.THREE, RatingStars.THREE);

        Customer customer = new Customer.Builder()
                .setEmail("VinDiesel@gmail.com")
                .setName("Vin")
                .setSurname("Diesel")
                .setPassword("see ya")
                .build();

        Review review = ReviewFactory.buildReview(-54333663L, rating, customer,"Driver took long");
        assertNotNull(review);
        System.out.println(review);
    }
}