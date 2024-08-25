package za.ac.cput.domain.embedded;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Suburb {

    private String suburbName;
    private int postalCode;

    protected Suburb(){}

    public String getSuburbName() {
        return suburbName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suburb suburb = (Suburb) o;
        return postalCode == suburb.postalCode && Objects.equals(suburbName, suburb.suburbName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suburbName, postalCode);
    }

    @Override
    public String toString() {
        return "Suburb{" +
                "suburbName='" + suburbName + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
