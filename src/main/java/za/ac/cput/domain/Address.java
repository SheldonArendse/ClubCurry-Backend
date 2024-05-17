package za.ac.cput.domain;

/*
Customer.Java
Address Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;

import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressCode;
    private String streetName;
    private String streetNumber;
    private String addressSuburb;
    private int postalCode;
    private String city;

    protected Address(){}

    public Address(Builder build) {
        this.addressCode = build.addressCode;
        this.streetName = build.streetName;
        this.streetNumber = build.streetNumber;
        this.addressSuburb = build.addressSuburb;
        this.postalCode = build.postalCode;
        this.city = build.city;
    }

    public Long getAddressCode() {
        return addressCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getAddressSuburb() {
        return addressSuburb;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return postalCode == address.postalCode && Objects.equals(addressCode, address.addressCode) && Objects.equals(streetName, address.streetName) && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(addressSuburb, address.addressSuburb) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressCode, streetName, streetNumber, addressSuburb, postalCode, city);
    }

    public static class Builder{
        private Long addressCode;
        private String streetName;
        private String streetNumber;
        private String addressSuburb;
        private int postalCode;
        private String city;

        public Builder setAddressCode(Long addressCode) {
            this.addressCode = addressCode;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setAddressSuburb(String addressSuburb) {
            this.addressSuburb = addressSuburb;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address obj){
            this.addressCode = obj.addressCode;
            this.streetName = obj.streetName;
            this.streetNumber = obj.streetNumber;
            this.addressSuburb = obj.addressSuburb;
            this.postalCode = obj.postalCode;
            this.city = obj.city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
