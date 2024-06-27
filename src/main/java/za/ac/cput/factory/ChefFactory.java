package za.ac.cput.factory;

import za.ac.cput.domain.Chef;
import za.ac.cput.domain.enums.ExpertLevel;
import za.ac.cput.utils.Validation;

public class ChefFactory {

    public static Chef buildChef(String name, String surname, String username, String password, ExpertLevel expertLevel){
        if(Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidString(username)
                && Validation.isValidPassword(password)){
            return new Chef.Builder()
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password)
                    .setExpertLevel(expertLevel)
                    .build();
        }
        return null;
    }
    public static Chef buildChef(String id, String name, String surname, String username, String password, ExpertLevel expertLevel){
        try{
            long i = Long.parseLong(id);
        }catch(NumberFormatException ex){
            System.out.println("Error: " + ex.getLocalizedMessage());
            return null;
        }

        if(id.length() == 13 && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidString(username)
                && Validation.isValidPassword(password)){
            return new Chef.Builder()
                    .setId(id)
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password)
                    .setExpertLevel(expertLevel)
                    .build();
        }
        return null;
    }
}
