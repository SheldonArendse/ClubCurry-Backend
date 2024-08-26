package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class ImageServiceTest {

 /*   @Autowired
    private ImageService imageService;


     private static Image image;

    @BeforeEach
    void a_setup(){
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
    void b_save() {
        Image savedImage = imageService.save(image);

        assertNotNull(savedImage);
        assertEquals(savedImage.getId(), image.getId());

    }

    @Test
    void c_read() {
        Image read = imageService.read(image.getId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Image newImage = new Image.Builder().copy(image).setType("Jpg").build();
        Image updated = imageService.update(newImage);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void f_delete() {
        imageService.delete(image.getId());
        System.out.println("image successfully deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(imageService.getAll());
    } */
}
