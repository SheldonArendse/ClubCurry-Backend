package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.factory.ImageFactory;
import za.ac.cput.service.ImageService;
import za.ac.cput.service.MenuItemService;

import java.io.File;
import java.io.IOException;

@Component
public class MenuItemImage {

    private ImageService imageService;
    private MenuItemService menuItemService;
    private String FOLDER_PATH = "/home/Logan/Documents/GitHub/ClubCurry/Images/";

    @Autowired
    public MenuItemImage(ImageService imageService, MenuItemService menuItemService) {
        this.imageService = imageService;
        this.menuItemService = menuItemService;
    }

    public Image canSave(Long id, MultipartFile file){
        MenuItem obj = menuItemService.read(id);

        if(obj == null){
            return null;
        }

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            System.out.println("Error:" + e.getLocalizedMessage());
            return null;
        }

        return ImageFactory.buildImage(obj, filePath,file.getOriginalFilename(), file.getContentType());
    }

    public Image canUpdate(Long id, MultipartFile file){
        Image image = imageService.read(id);

        MenuItem menuItem = menuItemService.read(image.getItemId().getId());

        if(menuItem == null){
            return null;
        }

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            System.out.println("Error:" + e.getLocalizedMessage());
            return null;
        }

        return ImageFactory.buildImage(id, menuItem, filePath,file.getOriginalFilename(), file.getContentType());
    }
}
