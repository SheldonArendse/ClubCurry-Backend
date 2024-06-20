package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.HashMap;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String email;

    private String name, surname, mobileNo, password;

    @OneToMany
    @JoinColumn(name = "customer_email")
    private List<Address> addresses;

}
