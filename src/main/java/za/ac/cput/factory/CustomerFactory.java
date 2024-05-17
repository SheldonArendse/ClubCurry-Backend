package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.util.CustomerHelper;

import java.util.List;

/*
Customer.Java
Customer Factory Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */
public class CustomerFactory {

    public static Customer buildCustomer(String email, String firstName, String lastName, String mobileNumber, String password, List<Address> custAddress, List<PaymentMethod> paymentMethod) {
        if (CustomerHelper.testEmail(email) ||
                CustomerHelper.testString(firstName) ||
                CustomerHelper.testString(lastName) ||
                CustomerHelper.testValidMobile(mobileNumber) ||
                CustomerHelper.testString(password) ||
                CustomerHelper.testListAddress(custAddress) ||
                CustomerHelper.testListPayMethod(paymentMethod)) {
return  null;
        }
        return new Customer.Builder().setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .setPassword(password)
                .setCustAddress(custAddress)
                .setPaymentMethod(paymentMethod)
                .build();
    }

    public static Customer buildCustomer(String firstName, String lastName, String mobileNumber, String password, List<Address> custAddress, List<PaymentMethod> paymentMethod) {
        if (
                CustomerHelper.testString(firstName) ||
                CustomerHelper.testString(lastName) ||
                CustomerHelper.testValidMobile(mobileNumber) ||
                CustomerHelper.testString(password) ||
                CustomerHelper.testListAddress(custAddress) ||
                CustomerHelper.testListPayMethod(paymentMethod)) {
            return  null;
        }
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .setPassword(password)
                .setCustAddress(custAddress)
                .setPaymentMethod(paymentMethod)
                .build();
    }
}
