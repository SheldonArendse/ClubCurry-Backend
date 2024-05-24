package za.ac.cput.factory;

import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.TimeAllocation;
import za.ac.cput.util.Helper;

import java.util.Date;

public class TimeAllocationFactory {
    public static TimeAllocation buildTimeAllocation(String timerId, Order order, Date datePrepared, Chef preparedBy) {
        if(Helper.isNullOrEmpty(timerId)
                || Helper.isNullOrEmpty(order)
                || Helper.isNullOrEmpty(datePrepared)
                || Helper.isNullOrEmpty(preparedBy))
        {
            return null;
        }
        return new TimeAllocation.Builder()
                .setTimerId(timerId)
                .setOrder(order)
                .setDatePrepared(datePrepared)
                .setPreparedBy(preparedBy)
                .build();
    }

    public static TimeAllocation buildTimeAllocation(String timerId) {
        if(Helper.isNullOrEmpty(timerId)) {
            return new TimeAllocation.Builder()
                    .setTimerId(timerId)
                    .build();
        }
        return null;
    }
}
