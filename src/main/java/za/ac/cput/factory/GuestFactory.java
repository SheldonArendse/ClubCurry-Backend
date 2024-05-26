package za.ac.cput.factory;

/*
Customer.Java
Guest Factory Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.util.CustomerHelper;
import za.ac.cput.util.Helper;

import java.util.List;

public class GuestFactory {
    public static Guest buildGuest(String email, String firstName, String lastName, String mobileNumber, Address guestAddress, PaymentMethod paymentMethod){
        if (CustomerHelper.testEmail(email)
                ||CustomerHelper.testString(firstName)
        ||CustomerHelper.testString(lastName)
    ||CustomerHelper.testValidMobile(mobileNumber)
        || Helper.isNullOrEmpty(guestAddress)
        ||Helper.isNullOrEmpty(paymentMethod)){
            return null;
        }
        return new Guest.Builder().setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .setGuestAddress(guestAddress)
                .setPaymentMethod(paymentMethod)
                .build();
    }

    public static Guest buildGuest(String firstName, String lastName, String mobileNumber, Address guestAddress, PaymentMethod paymentMethod){
        if (CustomerHelper.testString(firstName)
                ||CustomerHelper.testString(lastName)
                ||CustomerHelper.testValidMobile(mobileNumber)
                || Helper.isNullOrEmpty(guestAddress)
                ||Helper.isNullOrEmpty(paymentMethod)){
            return null;
        }
        return new Guest.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .setGuestAddress(guestAddress)
                .setPaymentMethod(paymentMethod)
                .build();
    }

    public static Guest buildGuest(String email){
        if (CustomerHelper.testEmail(email)){
            return null;
        }
        return new Guest.Builder()
                .setEmail(email)
                .build();
    }


}
