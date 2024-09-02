package za.ac.cput.domain;

import jakarta.persistence.Entity;

/**
 * Represents an Admin entity that extends the Employee class.
 * The Admin entity is used to manage admin-specific attributes and behaviors.
 */
@Entity
public class Admin extends Employee {

    // Protected no-args constructor for JPA
    protected Admin() {}

    // Constructor using Builder pattern to initialize an Admin instance
    public Admin(Builder obj) {
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
        this.password = obj.password;
        this.username = obj.username;
    }

    // Overrides the toString method to provide a string representation of the Admin object
    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Builder class for constructing an Admin object using the Builder pattern.
     */
    public static class Builder {
        private String id;
        private String name, surname, username, password;

        public Builder setId(String id) {
            this.id = id;
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

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        // Copies the fields from an existing GeneralStaff object to this Builder
        public Builder copy(GeneralStaff obj) {
            this.id = obj.id;
            this.name = obj.name;
            this.surname = obj.surname;
            this.password = obj.password;
            this.username = obj.username;
            return this;
        }

        // Builds and returns an Admin instance using the Builder pattern
        public Admin build() {
            return new Admin(this);
        }
    }
}
