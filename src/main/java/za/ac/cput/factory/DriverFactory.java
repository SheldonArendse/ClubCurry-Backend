package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.DriverHelper;
import za.ac.cput.util.Helper;

public class DriverFactory {

    public static Driver createDriver(String driverId, Vehicle vehicle) {
        if (Helper.isNullOrEmpty(driverId)
                || vehicle == null) {
            return null;
        }

        if (DriverHelper.isRegistrationNumberUsed(vehicle.getRegistration())) {
            return null;
        }

        Driver driver = new Driver.Builder()
                .setDriverId(driverId)
                .setRegistration(vehicle)
                .build();

        DriverHelper.addUsedRegistrationNumber(vehicle.getRegistration());

        return driver;
    }
}