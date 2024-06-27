package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.utils.Validation;

public class DriverFactory {
        public static Driver buildDriver(double petrolAllowance, Vehicle registration, String name, String surname, String password, String username){
            if(registration !=null
                    && Validation.isValidString(name)
                    && Validation.isValidString(surname)
                    && Validation.isValidPassword(password)
                    && !username.isEmpty()){
                return new Driver.Builder()
                        .setName(name)
                        .setRegistration(registration)
                        .setPetrolAllowance(petrolAllowance)
                        .setSurname(surname)
                        .setUsername(username)
                        .setPassword(password).build();
            }
            return null;
        }
    public static Driver buildDriver(String id, double petrolAllowance, Vehicle registration, String name, String surname, String password, String username){
        try{
            long i = Long.parseLong(id);
        }catch(NumberFormatException ex){
            System.out.println("Error: " + ex.getLocalizedMessage());
            return null;
        }

        if(registration !=null && id.length() == 13
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidPassword(password)
                && !username.isEmpty()){
            return new Driver.Builder()
                    .setName(name)
                    .setRegistration(registration)
                    .setPetrolAllowance(petrolAllowance)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password).build();
        }
        return null;
    }
}
