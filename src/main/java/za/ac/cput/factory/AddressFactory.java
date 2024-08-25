package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.embedded.Suburb;
import za.ac.cput.utils.Validation;

public class AddressFactory {

    public static Address buildAddress(String streetName, String streetNo, String suburbName, int postalCode, Customer customerId){
        if(Validation.isValidString(streetName) && Validation.isValidEmail(customerId.getEmail())
                && Validation.isValidStreetNo(streetNo)
                && Validation.isValidString(suburbName)
                && Validation.isValidPostalCode(postalCode)){

            Suburb suburb = new Suburb.Builder()
                    .setSuburbName(suburbName)
                    .setPostalCode(postalCode)
                    .build();

            return new Address.Builder()
                    .setStreetName(streetName)
                    .setStreetNo(streetNo)
                    .setSuburb(suburb)
                    .setCustomerId(customerId)
                    .build();
        }
        return null;
    }
    public static Address buildAddress(Long id, String streetName, String streetNo, String suburbName, int postalCode){
        if(Validation.isValidString(streetName)
                && Validation.isValidStreetNo(streetNo)
                && Validation.isValidString(suburbName)
                && Validation.isValidPostalCode(postalCode)){

            Suburb suburb = new Suburb.Builder()
                    .setSuburbName(suburbName)
                    .setPostalCode(postalCode)
                    .build();

            return new Address.Builder()
                    .setId(id)
                    .setStreetName(streetName)
                    .setStreetNo(streetNo)
                    .setSuburb(suburb)
                    .build();
        }
        return null;
    }
    public static Address buildAddress(Long id,  Customer customerId){
        if(Validation.isValidEmail(customerId.getEmail()) && Validation.isValidEmail(customerId.getEmail())){
            return new Address.Builder()
                    .setId(id)
                    .setCustomerId(customerId)
                    .build();
        }
        return null;
    }
}
