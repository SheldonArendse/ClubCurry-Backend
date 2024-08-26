package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class ReviewServiceTest {

   /* @Autowired
    private ReviewService reviewService;

    private Review review;
    private Orders order;

    private Rating rating;
    private Customer customer;

    @BeforeEach
    void a_setUp() {
        order = new Orders.Builder().setId(67L).build();

        RatingStars foodQuality = RatingStars.ONE;
        RatingStars deliveryQuality = RatingStars.TWO;

        rating = RatingFactory.buildRating(32L, order, foodQuality, deliveryQuality);

        customer = new Customer.Builder()
                .setEmail("Sara@gmail.com")
                .setMobileNo("0214683729")
                .setName("Sara")
                .setSurname("Davids")
                .setPassword("Goodbye")
                .build();

        review = ReviewFactory.buildReview(5L,rating, customer,"Poor Service!");


    }

    @Test
    void a_save() {
       Review savedReview = reviewService.save(review);
       assertNotNull(savedReview);
        System.out.println(savedReview);
    }

    @Test
    void b_read() {
        Review read = reviewService.read(5L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Review updatedReview = new Review.Builder().copy(review).setNote("Great Service!").build();
        Review savedUpdatedReview = reviewService.update(updatedReview);

        assertNotNull(savedUpdatedReview);
        System.out.println(savedUpdatedReview);
    }

    @Test
    @Disabled
    void e_delete() {
        reviewService.delete(rating.getId());
        System.out.println("review successfully deleted");
    }

    @Test
    void d_getAll() {
        System.out.println(reviewService.getAll());
    }*/
}