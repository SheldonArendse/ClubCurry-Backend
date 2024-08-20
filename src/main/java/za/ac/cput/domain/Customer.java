package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    private String email;

    private String name, surname, mobileNo, password;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> addresses;

    protected Customer(){}

    public Customer(Builder obj) {
        this.email = obj.email;
        this.name = obj.name;
        this.surname = obj.surname;
        this.mobileNo = obj.mobileNo;
        this.password = obj.password;
        this.addresses =obj.addresses;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(mobileNo, customer.mobileNo) && Objects.equals(password, customer.password) && Objects.equals(addresses, customer.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, surname, mobileNo, password, addresses);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    public static class Builder{
        private String email;

        private String name, surname, mobileNo, password;

        private List<Address> addresses;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder copy(Customer obj){
            this.email = obj.email;
            this.name = obj.name;
            this.surname = obj.surname;
            this.mobileNo = obj.mobileNo;
            this.password = obj.password;
            this.addresses =obj.addresses;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
