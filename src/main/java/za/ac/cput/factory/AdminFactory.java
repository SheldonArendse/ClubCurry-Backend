package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.utils.Validation;

public class AdminFactory {
    public static Admin buildAdmin(String id, String name, String surname, String username, String password) {
        try {
            long i = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            return null;
        }

        if (id.length() == 13 && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidString(username)
                && Validation.isValidPassword(password)) {
            return new Admin.Builder()
                    .setId(id)
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password)
                    .build();
        }
        return null;
    }
}
