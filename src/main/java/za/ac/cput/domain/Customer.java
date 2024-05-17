package za.ac.cput.domain;

/*
Customer.Java
Customer Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.context.PayloadApplicationEvent;

import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String password;
    @OneToMany
    private List<Address> custAddress;
    @OneToMany
    private List<PaymentMethod> paymentMethod;

    protected Customer(){}

    public Customer(Builder build) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.custAddress = custAddress;
        this.paymentMethod = paymentMethod;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public List<Address> getCustAddress() {
        return custAddress;
    }

    public List<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(email, customer.email) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(password, customer.password) && Objects.equals(custAddress, customer.custAddress) && Objects.equals(paymentMethod, customer.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, mobileNumber, password, custAddress, paymentMethod);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", custAddress=" + custAddress +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    public static class Builder{
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String password;
        private List<Address> custAddress;
        private List<PaymentMethod> paymentMethod;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCustAddress(List<Address> custAddress) {
            this.custAddress = custAddress;
            return this;
        }

        public Builder setPaymentMethod(List<PaymentMethod> paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Customer obj){
            this.email = obj.email;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.mobileNumber = obj.mobileNumber;
            this.password = obj.password;
            this.custAddress = obj.custAddress;
            this.paymentMethod = obj.paymentMethod;
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }
    }
}
