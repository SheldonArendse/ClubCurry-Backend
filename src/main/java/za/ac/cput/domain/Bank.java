package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bankId;
    private String name;
    private Integer branchCode;

    public Bank() {
    }

    public Bank(Builder builder) {
        this.name = builder.name;
        this.branchCode = builder.branchCode;
        this.bankId = builder.bankId;
    }

    public String getBankId() {
        return bankId;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankId, bank.bankId) && Objects.equals(name, bank.name) && Objects.equals(branchCode, bank.branchCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankId, name, branchCode);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId='" + bankId + '\'' +
                ", name='" + name + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }

    public static class Builder {
        private String bankId;
        private String name;
        private Integer branchCode;

        public Builder setBankId(String bankId) {
            this.bankId = bankId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBranchCode(Integer branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public Builder copy(Bank bank){
            this.bankId = bank.getBankId();
            this.name = bank.getName();
            this.branchCode = bank.getBranchCode();
            return this;
        }

        public Bank build() {
            return new Bank(this);
        }
    }
}
