package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Coupon;
import za.ac.cput.repository.CouponRepository;

import java.util.List;

@Service
public class CouponService implements ICouponService{
    private CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon create(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon read(String couponId) {
        return couponRepository.findById(couponId).orElse(null);
    }

    @Override
    public Coupon update(Coupon coupon) {
        return couponRepository.save(coupon);
    }
    @Override
    public void delete(String couponId) {
        couponRepository.deleteById(couponId);

    }

    @Override
    public List<Coupon> getall() {
        return couponRepository.findAll();
    }
}
