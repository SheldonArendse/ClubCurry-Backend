package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.Review;
import za.ac.cput.utils.Validation;
public class ReviewFactory {
    public static Review buildReview(Rating rating, Customer customer,String note){
        if( rating !=null && customer !=null && Validation.isValidString(note)){
            return new Review.Builder().setRating(rating).setCustomer(customer).setNote(note).build();
        }
        return null;
    }

    public static Review buildReview(long id, Rating rating, Customer customer,String note){
        if( id>0 && rating !=null && customer !=null && Validation.isValidString(note)){
            return new Review.Builder().setId(id).setRating(rating).setCustomer(customer).setNote(note).build();
        }
        return null;
    }
}
