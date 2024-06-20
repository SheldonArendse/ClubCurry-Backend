package za.ac.cput.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class Suburb {

    private String suburbName;

    private int postalCode;
}
