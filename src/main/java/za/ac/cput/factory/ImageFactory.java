package za.ac.cput.factory;

import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.utils.Validation;

public class ImageFactory {

    public static Image buildImage(MenuItem menuItem, byte[] imageData, String name, String type){
        if(menuItem != null
                && imageData != null
                && Validation.isValidString(name)
                && Validation.isValidString(type)){
            return new Image.Builder()
                    .setName(name)
                    .setPhoto(imageData)
                    .setItemId(menuItem)
                    .setType(type).build();
        }
        return null;
    }
    public static Image buildImage(long id, MenuItem menuItem, byte[] imageData, String name, String type){
        if(menuItem != null
                && imageData != null
                && Validation.isValidString(name)
                && Validation.isValidString(type)){
            return new Image.Builder()
                    .setId(id)
                    .setName(name)
                    .setPhoto(imageData)
                    .setItemId(menuItem)
                    .setType(type).build();
        }
        return null;
    }
}
