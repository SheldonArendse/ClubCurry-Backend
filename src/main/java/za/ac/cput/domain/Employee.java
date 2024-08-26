package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@MappedSuperclass
public class Employee {
    @Id
    protected String id;
    @Column(unique = true)
    protected String username;

    protected String name, surname, password;

    protected Employee(){}


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(username, employee.username) && Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, username, password);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
