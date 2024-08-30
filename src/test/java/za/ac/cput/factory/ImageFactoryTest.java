package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;

import static org.junit.jupiter.api.Assertions.*;

class ImageFactoryTest {

    @Test
    void buildImage() {
        MenuItem menuItem = MenuItemFactory.buildMenuItem(3L);
        Image obj = ImageFactory.buildImage(menuItem,"?/?/The/path","imageOrginalName", "image/png");
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildImage() {
        MenuItem menuItem = MenuItemFactory.buildMenuItem(3L);
        Image obj = ImageFactory.buildImage(3L,menuItem,"?/?/The/path","imageOrginalName", "image/png");
        assertNotNull(obj);
        System.out.println(obj);
    }
    @Test
    void buildImageFail() {
        MenuItem menuItem = MenuItemFactory.buildMenuItem(3L);
        Image obj = ImageFactory.buildImage(menuItem,"?/?/The/path","imageOrginalName", "image/png");
        assertNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildImageFail() {
        MenuItem menuItem = MenuItemFactory.buildMenuItem(3L);
        Image obj = ImageFactory.buildImage(-3L,menuItem,"?/?/The/path","imageOrginalName", "image/png");
        assertNull(obj);
        System.out.println(obj);
    }
}