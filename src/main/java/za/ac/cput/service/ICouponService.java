package za.ac.cput.service;

import za.ac.cput.domain.Coupon;

import java.util.List;

public interface ICouponService extends IService<Coupon, String>{
    void delete(String couponId);

    List<Coupon> getall();

}
