package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = ImageFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ImageFactoryTest {


    @Test
    @Order(1)
    void buildImage(){
        MenuItem menuItem = new MenuItem.Builder()
                .setName("Chicken")
                .setPrice(9.99)
                .build();

        String imageData = "imageDataString";
        Image image = ImageFactory.buildImage(menuItem, imageData, "ChickenImage", "jpg");
        assertNotNull(image);
        System.out.println(image);

    }

    @Test
    @Order(2)
    void buildImageFail(){
        MenuItem menuItem = new MenuItem.Builder()
                .setName("Chicken")
                .setPrice(9.99)
                .build();

        String imageData = "imageDataString";
        Image image = ImageFactory.buildImage(menuItem, imageData, " ", "jpg"); // Invalid name
        assertNull(image);
        System.out.println(image);
    }

    @Test
    @Order(3)
    void buildImageWithId(){
        MenuItem menuItem = new MenuItem.Builder()
                .setName("Steak")
                .setPrice(12.99)
                .build();

        String imageData = "imageDataString";
        Image image = ImageFactory.buildImage(123456, menuItem, imageData, "SteakImage", "png");
        assertNotNull(image);
        System.out.println(image);
    }

    @Test
    @Order(4)
    void buildImageWithIdFail(){
        MenuItem menuItem = new MenuItem.Builder()
                .setName("Steak")
                .setPrice(12.99)
                .build();

        String imageData = null;
        Image image = ImageFactory.buildImage(123456, menuItem, imageData, "SteakImage", "png");
        assertNotNull(image);
        System.out.println(image);
    }
}


