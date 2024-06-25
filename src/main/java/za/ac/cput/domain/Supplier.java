package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean canDeliver;

    private double pricePerUnit;

    private String contactNo;

    protected Supplier(){}

    public Supplier(Builder obj) {
        this.id = obj.id;
        this.canDeliver =  obj.canDeliver;
        this.pricePerUnit =  obj.pricePerUnit;
        this.contactNo =  obj.contactNo;
    }

    public long getId() {
        return id;
    }

    public boolean isCanDeliver() {
        return canDeliver;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getContactNo() {
        return contactNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id && canDeliver == supplier.canDeliver && Double.compare(pricePerUnit, supplier.pricePerUnit) == 0 && Objects.equals(contactNo, supplier.contactNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, canDeliver, pricePerUnit, contactNo);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", canDeliver=" + canDeliver +
                ", pricePerUnit=" + pricePerUnit +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }

    public static class Builder{
        private long id;

        private boolean canDeliver;

        private double pricePerUnit;

        private String contactNo;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCanDeliver(boolean canDeliver) {
            this.canDeliver = canDeliver;
            return this;
        }

        public Builder setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
            return this;
        }

        public Builder setContactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public Builder copy(Supplier obj){
            this.id = obj.id;
            this.canDeliver =  obj.canDeliver;
            this.pricePerUnit =  obj.pricePerUnit;
            this.contactNo =  obj.contactNo;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }
    }
}
