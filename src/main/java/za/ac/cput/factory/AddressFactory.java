package za.ac.cput.factory;

/*
Customer.Java
Address Factory Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import za.ac.cput.domain.Address;
import za.ac.cput.util.CustomerHelper;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address buildAddress(Long addressCode, String streetName, String streetNumber, String addressSuburb, int postalCode, String city) {
        if (CustomerHelper.testLong(addressCode) ||
                CustomerHelper.testString(streetName) ||
                CustomerHelper.testString(streetNumber) ||
                CustomerHelper.testString(addressSuburb) ||
                Helper.isNull(postalCode) ||
                CustomerHelper.testString(city)) {
            return null;
        }
        return new Address.Builder().setAddressCode(addressCode)
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                .setPostalCode(postalCode)
                .setAddressSuburb(addressSuburb)
                .setCity(city)
                .build();
    }

    public static Address buildAddress(String streetName, String streetNumber, String addressSuburb, int postalCode, String city) {
        if (
                CustomerHelper.testString(streetName) ||
                CustomerHelper.testString(streetNumber) ||
                CustomerHelper.testString(addressSuburb) ||
                Helper.isNull(postalCode) ||
                CustomerHelper.testString(city)) {
            return null;
        }
        return new Address.Builder()
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                .setPostalCode(postalCode)
                .setAddressSuburb(addressSuburb)
                .setCity(city)
                .build();
    }
}
