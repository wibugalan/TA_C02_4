package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;

import java.util.List;

public interface CouponService {
    List<CouponModel> getListCoupon();
    CouponModel getCouponById(Long id);
    void updateCoupon(CouponModel coupon);
}
