package za.ac.cput.factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.enums.RatingStars;

public class RatingFactory {

    public static Rating buildRating(Orders order, RatingStars foodQuality, RatingStars deliveryQuality){
        if(order !=null && foodQuality !=null && deliveryQuality !=null){
            return new Rating.Builder()
                    .setOrder(order)
                    .setFoodQuality(foodQuality)
                    .setDeliveryQuality(deliveryQuality).build();
        }
        return null;
    }
    public static Rating buildRating(Long id, Orders order, RatingStars foodQuality, RatingStars deliveryQuality){
        if(id>0 && order !=null && foodQuality !=null && deliveryQuality !=null){
            return new Rating.Builder()
                    .setId(id)
                    .setOrder(order)
                    .setFoodQuality(foodQuality)
                    .setDeliveryQuality(deliveryQuality).build();
        }
        return null;
    }
}
