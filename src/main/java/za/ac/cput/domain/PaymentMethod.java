package za.ac.cput.domain;

/*
Customer.Java
PaymentMethod Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentID;
    private String cardName;
    private Long cardNumber;
    private Date expirationDate;
    private int cardCVV;

    protected PaymentMethod(){}

    public PaymentMethod(Builder build) {
        this.paymentID = build.paymentID;
        this.cardName = build.cardName;
        this.cardNumber = build.cardNumber;
        this.expirationDate = build.expirationDate;
        this.cardCVV = build.cardCVV;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getCardName() {
        return cardName;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getCardCVV() {
        return cardCVV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod that)) return false;
        return cardCVV == that.cardCVV && Objects.equals(paymentID, that.paymentID) && Objects.equals(cardName, that.cardName) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, cardName, cardNumber, expirationDate, cardCVV);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentID='" + paymentID + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardNumber=" + cardNumber +
                ", expirationDate=" + expirationDate +
                ", cardCVV=" + cardCVV +
                '}';
    }

    public static class Builder{
        private String paymentID;
        private String cardName;
        private Long cardNumber;
        private Date expirationDate;
        private int cardCVV;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setCardName(String cardName) {
            this.cardName = cardName;
            return this;
        }

        public Builder setCardNumber(Long cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder setExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder setCardCVV(int cardCVV) {
            this.cardCVV = cardCVV;
            return this;
        }

        public Builder copy(PaymentMethod obj){
            this.paymentID = obj.paymentID;
            this.cardName = obj.cardName;
            this.cardNumber = obj.cardNumber;
            this.expirationDate = obj.expirationDate;
            this.cardCVV = obj.cardCVV;
            return this;
        }
        public PaymentMethod build(){
            return new PaymentMethod(this);
        }
    }
}
