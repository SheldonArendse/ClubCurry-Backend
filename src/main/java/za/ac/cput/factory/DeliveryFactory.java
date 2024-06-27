package za.ac.cput.factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Orders;

import java.sql.Date;

public class DeliveryFactory {

    public static Delivery buildDelivery(boolean delivered, Date completed, Driver driver, Orders order){
        if(driver != null && order != null){
            return new Delivery.Builder()
                    .setDelivered(delivered)
                    .setCompleted(completed)
                    .setDriver(driver)
                    .setOrder(order).build();
        }
        return null;
    }
    public static Delivery buildDelivery(Long id, boolean delivered, Date completed, Driver driver, Orders order){
        if(driver != null && order != null && id>=0){
            return new Delivery.Builder()
                    .setId(id)
                    .setDelivered(delivered)
                    .setCompleted(completed)
                    .setDriver(driver)
                    .setOrder(order).build();
        }
        return null;
    }
}
