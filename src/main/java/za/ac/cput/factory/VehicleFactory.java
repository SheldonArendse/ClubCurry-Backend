package za.ac.cput.factory;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.DriverHelper;
import za.ac.cput.util.Helper;

public class VehicleFactory {

    public static Vehicle createVehicle(String registrationNumber, String model, String color, String make) {
        if (Helper.isNullOrEmpty(registrationNumber)
                || Helper.isNullOrEmpty(model)
                || Helper.isNullOrEmpty(color)
                || Helper.isNullOrEmpty(make)) {
            return null;
        }

        if (!DriverHelper.testValidRegistrationNumber(registrationNumber)) {
            return null;
        }

        Vehicle vehicle = new Vehicle.Builder()
                .setRegistration(registrationNumber)
                .setModel(model)
                .setColor(color)
                .setMake(make)
                .build();

        return vehicle;
    }
}