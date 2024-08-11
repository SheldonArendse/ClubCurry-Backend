package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.facade.MenuItemImage;
import za.ac.cput.factory.MenuItemFactory;
import za.ac.cput.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;
    private MenuItemImage menuItemImage;

    @Autowired
    public ImageController(ImageService imageService, MenuItemImage menuItemImage) {
        this.imageService = imageService;
        this.menuItemImage = menuItemImage;
    }

    @PostMapping("/save")
    public ResponseEntity<Image> save(@RequestParam("image")MultipartFile file, @RequestParam("itemId") Long id){
        Image canSave = menuItemImage.canSave(id,file);
        if(canSave == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(imageService.save(canSave));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<byte[]> read(@PathVariable Long id){
        Image image = imageService.read(id);
        if(image == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        try {
            byte[] actImage = Files.readAllBytes(new File(image.getPhoto()).toPath());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(actImage);
        } catch (IOException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }

    @PutMapping("/updatePhoto/{id}")
    public ResponseEntity<Image> update(@PathVariable Long id, @RequestParam("image")MultipartFile file){
        Image image = menuItemImage.canUpdate(id,file);

        if(image == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(imageService.update(image));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(imageService.delete(id));
    }

    @GetMapping(value="/getAll")
    public ResponseEntity<List<Image>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(imageService.getAll());

    }

    @GetMapping("/getByMenuId/{id}")
    public ResponseEntity<byte[]> getByMenuId(@PathVariable MenuItem id){
        MenuItem obj = MenuItemFactory.buildMenuItem(id.getId());

        Image image = imageService.findImageByItemId(obj);
        if(image == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        try {
            byte[] actImage = Files.readAllBytes(new File(image.getPhoto()).toPath());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(actImage);
        } catch (IOException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }
}
