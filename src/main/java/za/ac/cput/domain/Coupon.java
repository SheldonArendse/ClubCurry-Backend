package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Coupon {
    @Id
    private String couponId;
    private String Code;
    private double Reduction;
    private Date Expires;

    protected Coupon() {

    }

    public Coupon(Builder builder) {
        this.couponId = builder.couponId;
        this.Code = builder.Code;
        this.Reduction = builder.Reduction;
        this.Expires = builder.Expires;
    }

    public String getCouponId() {
        return couponId;
    }

    public String getCode() {
        return Code;
    }

    public double getReduction() {
        return Reduction;
    }

    public Date getExpires() {
        return Expires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Double.compare(Reduction, coupon.Reduction) == 0 && Objects.equals(couponId, coupon.couponId) && Objects.equals(Code, coupon.Code) && Objects.equals(Expires, coupon.Expires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId, Code, Reduction, Expires);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId='" + couponId + '\'' +
                ", Code='" + Code + '\'' +
                ", Reduction=" + Reduction +
                ", Expires=" + Expires +
                '}';
    }

    public static class Builder{
        private String couponId;
        private String Code;
        private double Reduction;
        private Date Expires;

        public Builder setCouponId(String couponId) {
            this.couponId = couponId;
            return this;
        }

        public Builder setCode(String code) {
            Code = code;
            return this;
        }

        public Builder setReduction(double reduction) {
            Reduction = reduction;
            return this;
        }

        public Builder setExpires(Date expires) {
            Expires = expires;
            return this;
        }
        public Builder copy(Coupon coupon){
            this.couponId = coupon.couponId;
            this.Code = coupon.Code;
            this.Reduction = coupon.Reduction;
            this.Expires = coupon.Expires;
            return this;
        }
        public Coupon build(){
            return new Coupon(this);
        }
    }
}
