package za.ac.cput.factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.TimeAllocation;
import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

import java.sql.Time;

public class DeliveryFactory {
    public static Delivery createDelivery(String deliveryId, TimeAllocation deliveryTime, Boolean status, Driver driverId, Time deliveredAt, String deliveryNote) {
        if(Helper.isNullOrEmpty(deliveryId)
                ||  Helper.isNullOrEmpty(deliveryTime)
                || Helper.isNullOrEmpty(status)
                || Helper.isNullOrEmpty(driverId)
                || Helper.isNullOrEmpty(deliveredAt))
        {
            return null;
        }
        return new Delivery.Builder()
                .setDeliveryId(deliveryId)
                .setDeliveryTime(deliveryTime)
                .setStatus(status)
                .setDriverId(driverId)
                .setDeliveredAt(deliveredAt)
                .setDeliveryNote(deliveryNote)
                .build();
    }
}
