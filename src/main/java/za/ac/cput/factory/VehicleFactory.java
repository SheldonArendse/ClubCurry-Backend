package za.ac.cput.factory;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.utils.Validation;

public class VehicleFactory {

    public static Vehicle buildVehicle(String make, String model, String color){
        if(Validation.isValidString(make) && Validation.isValidString(model) && Validation.isValidString(color)){
            return new Vehicle.Builder().setMake(make).setModel(model).setColor(color).build();
        }
        return null;
    }
    public static Vehicle buildVehicle(long id, String make, String model, String color){
        if(Validation.isValidString(make) && Validation.isValidString(model) && Validation.isValidString(color)){
            return new Vehicle.Builder().setId(id).setMake(make).setModel(model).setColor(color).build();
        }
        return null;
    }
}
