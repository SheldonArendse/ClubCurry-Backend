package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class BankDetails{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String detailId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="bank_id")
    private Bank bank;
    private Long accountNumber;
    private char accountType;

    public BankDetails() {
    }

    public BankDetails(Builder builder) {
        this.detailId = builder.detailId;
        this.accountType = builder.accountType;
        this.accountNumber = builder.accountNumber;
        this.bank = builder.bank;
    }

    public String getDetailId() {
        return detailId;
    }

    public char getAccountType() {
        return accountType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDetails that = (BankDetails) o;
        return accountType == that.accountType && Objects.equals(detailId, that.detailId) && Objects.equals(bank, that.bank) && Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailId, bank, accountNumber, accountType);
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "detailId='" + detailId + '\'' +
                ", bank=" + bank +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                '}';
    }

    public static class Builder {
        private String detailId;
        private Bank bank;
        private Long accountNumber;
        private char accountType;

        public Builder setDetailId(String detailId) {
            this.detailId = detailId;
            return this;
        }

        public Builder setAccountNumber(Long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setAccountType(char accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setBank(Bank bank) {
            this.bank = bank;
            return this;
        }

        public Builder copy(BankDetails bankDetails){
            this.detailId = bankDetails.getDetailId();
            this.bank = bankDetails.getBank();
            this.accountNumber = bankDetails.getAccountNumber();
            this.accountType = bankDetails.getAccountType();
            return this;
        }

        public BankDetails build() {
            return new BankDetails(this);
        }
    }
}
