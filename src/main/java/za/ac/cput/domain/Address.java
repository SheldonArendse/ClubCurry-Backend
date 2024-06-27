package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.embedded.Suburb;

import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String streetName, streetNo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="suburbName", column = @Column(name = "suburb_name")),
            @AttributeOverride(name="postalCode", column = @Column(name = "suburb_postal_code"))
    })
    private Suburb suburb;

    protected Address(){};

    public Address(Builder obj) {
        this.id = obj.id;
        this.streetName = obj.streetName;
        this.streetNo = obj.streetNo;
        this.suburb = obj.suburb;
    }

    public long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(streetName, address.streetName) && Objects.equals(streetNo, address.streetNo) && Objects.equals(suburb, address.suburb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetName, streetNo, suburb);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", suburb=" + suburb +
                '}';
    }

    public static class Builder{
        private long id;

        private String streetName, streetNo;
        private Suburb suburb;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setStreetNo(String streetNo) {
            this.streetNo = streetNo;
            return this;
        }

        public Builder setSuburb(Suburb suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder copy(Address obj){
            this.id = obj.id;
            this.streetName = obj.streetName;
            this.streetNo = obj.streetNo;
            this.suburb = obj.suburb;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
