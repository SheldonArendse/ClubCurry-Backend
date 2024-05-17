package za.ac.cput.factory;

/*
Customer.Java
PaymentMethod Factory Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.util.CustomerHelper;
import za.ac.cput.util.Helper;
import java.util.Date;

public class PaymentMethodFactory {
    public static PaymentMethod buildPaymentMethod(String paymentID, String cardName, Long cardNumber, Date expirationDate, int cardCVV) {

        if (CustomerHelper.testString(paymentID)
                || CustomerHelper.testString(cardName)
                || CustomerHelper.testLong(cardNumber)
                || Helper.isNullOrEmpty(expirationDate)
                || Helper.isNull(cardCVV)) {
            return null;
        }
        return new PaymentMethod.Builder()
                .setPaymentID(paymentID)
                .setCardName(cardName)
                .setCardNumber(cardNumber)
                .setExpirationDate(expirationDate)
                .setCardCVV(cardCVV).build();
    }

    public static PaymentMethod buildPaymentMethod(String cardName, Long cardNumber, Date expirationDate, int cardCVV) {

        if (CustomerHelper.testString(cardName)
                        || CustomerHelper.testLong(cardNumber)
                        || Helper.isNullOrEmpty(expirationDate)
                        || Helper.isNull(cardCVV)) {
            return null;
        }
        return new PaymentMethod.Builder()
                .setCardName(cardName)
                .setCardNumber(cardNumber)
                .setExpirationDate(expirationDate)
                .setCardCVV(cardCVV).build();
    }
}
