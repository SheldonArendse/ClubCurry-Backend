package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.utils.Validation;

public class SupplierFactory {

    public static Supplier buildSupplier(boolean canDeliver, double pricePerUnit, String contactNo){
        if(pricePerUnit > 0 && Validation.isValidMobileNo(contactNo)){
            return new Supplier.Builder()
                    .setCanDeliver(canDeliver)
                    .setPricePerUnit(pricePerUnit)
                    .setContactNo(contactNo).build();
        }
        return null;
    }
    public static Supplier buildSupplier(long id, boolean canDeliver, double pricePerUnit, String contactNo){
        if(pricePerUnit > 0 && Validation.isValidMobileNo(contactNo)){
            return new Supplier.Builder()
                    .setId(id)
                    .setCanDeliver(canDeliver)
                    .setPricePerUnit(pricePerUnit)
                    .setContactNo(contactNo).build();
        }
        return null;
    }
}
