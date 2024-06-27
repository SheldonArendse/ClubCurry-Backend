package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.enums.CollectionType;
import za.ac.cput.domain.enums.PaymentMethod;

import java.sql.Date;

public class OrderFactory {

    public static Orders buildOrder(Date ordered, Cart cart, double total, Date orderWanted, boolean isComplete, PaymentMethod paymentMethod, CollectionType collectionType){
        if(total < 0 && cart !=null && paymentMethod !=null && collectionType !=null){
            return new Orders.Builder()
                    .setOrdered(ordered)
                    .setCart(cart)
                    .setTotal(total)
                    .setOrderWanted(orderWanted)
                    .setPaymentMethod(paymentMethod)
                    .setComplete(isComplete)
                    .setCollectionType(collectionType).build();
        }
        return null;
    }
    public static Orders buildOrder(Long id, Date ordered, Cart cart, double total, Date orderWanted, boolean isComplete, PaymentMethod paymentMethod, CollectionType collectionType){
        if(total < 0 && cart !=null && paymentMethod !=null && collectionType !=null){
            return new Orders.Builder()
                    .setId(id)
                    .setOrdered(ordered)
                    .setCart(cart)
                    .setTotal(total)
                    .setOrderWanted(orderWanted)
                    .setPaymentMethod(paymentMethod)
                    .setComplete(isComplete)
                    .setCollectionType(collectionType).build();
        }
        return null;
    }
}
