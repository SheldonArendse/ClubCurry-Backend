package za.ac.cput.domain;

/*
Customer.Java
Guest Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.NotFound;

import java.util.List;
import java.util.Objects;

@Entity
public class Guest {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    @OneToOne
    private Address guestAddress;
    @OneToOne
    private PaymentMethod paymentMethod;

    protected Guest(){}

    public Guest(Builder build) {
        this.email = build.email;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.mobileNumber = build.mobileNumber;
        this.guestAddress = build.guestAddress;
        this.paymentMethod = build.paymentMethod;
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

    public Address getGuestAddress() {
        return guestAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;
        return Objects.equals(email, guest.email) && Objects.equals(firstName, guest.firstName) && Objects.equals(lastName, guest.lastName) && Objects.equals(mobileNumber, guest.mobileNumber) && Objects.equals(guestAddress, guest.guestAddress) && Objects.equals(paymentMethod, guest.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, mobileNumber, guestAddress, paymentMethod);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", guestAddress=" + guestAddress +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    public static class Builder{
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private Address guestAddress;
        private PaymentMethod paymentMethod;

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

        public Builder setGuestAddress(Address guestAddress) {
            this.guestAddress = guestAddress;
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Guest obj){
            this.email = obj.email;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.mobileNumber = obj.mobileNumber;
            this.guestAddress = obj.guestAddress;
            this.paymentMethod = obj.paymentMethod;
            return this;
        }
        public Guest build(){
            return new Guest(this);
        }
    }
}
