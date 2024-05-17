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

import java.util.List;

public class GuestFactory {
    public static Guest buildGuest(String email, String firstName, String lastName, String mobileNumber, List<Address> guestAddress, List<PaymentMethod> paymentMethod){
        if (CustomerHelper.testEmail(email)
                ||CustomerHelper.testString(firstName)
        ||CustomerHelper.testString(lastName)
    ||CustomerHelper.testValidMobile(mobileNumber)
        ||CustomerHelper.testListAddress(guestAddress)
        ||CustomerHelper.testListPayMethod(paymentMethod)){
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

    public static Guest buildGuest(String firstName, String lastName, String mobileNumber, List<Address> guestAddress, List<PaymentMethod> paymentMethod){
        if (CustomerHelper.testString(firstName)
                ||CustomerHelper.testString(lastName)
                ||CustomerHelper.testValidMobile(mobileNumber)
                ||CustomerHelper.testListAddress(guestAddress)
                ||CustomerHelper.testListPayMethod(paymentMethod)){
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
}
