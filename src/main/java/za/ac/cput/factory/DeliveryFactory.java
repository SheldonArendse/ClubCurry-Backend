package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.enums.DeliveryStatus;

import java.sql.Date;
import java.time.LocalTime;

public class DeliveryFactory {

    public static Delivery buildDelivery(boolean delivered, Date completed, Driver driver, Orders order, Address address, LocalTime timeOfDelivery, DeliveryStatus status, LocalTime estimatedDeliveryTime){
        if(driver != null && order != null && address !=null){
            return new Delivery.Builder()
                    .setDelivered(delivered)
                    .setCompleted(completed)
                    .setDriver(driver)
                    .setAddress(address)
                    .setOrder(order)
                    .setStatus(status)
                    .setTimeOfDelivery(timeOfDelivery)
                    .setEstimatedDeliveryTime(estimatedDeliveryTime)
                    .build();
        }
        return null;
    }
    public static Delivery buildDelivery(Long id, boolean delivered, Date completed, Driver driver, Orders order, Address address,  LocalTime timeOfDelivery, DeliveryStatus status, LocalTime estimatedDeliveryTime){
        if(driver != null && order != null && id>=0 && address !=null){
            return new Delivery.Builder()
                    .setId(id)
                    .setDelivered(delivered)
                    .setCompleted(completed)
                    .setDriver(driver)
                    .setAddress(address)
                    .setOrder(order)
                    .setStatus(status)
                    .setTimeOfDelivery(timeOfDelivery)
                    .setEstimatedDeliveryTime(estimatedDeliveryTime)
                    .build();
        }
        return null;
    }
}
