package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;

import java.util.List;

public interface CouponService {
    List<CouponModel> getListCoupon();
    CouponModel getCouponById(Long id);
    void updateCoupon(CouponModel coupon);
    void addCoupon(CouponModel coupon);
    CouponModel approveCoupon(Long id);
    void rejectCoupon(Long id);
    void deleteCoupon(CouponModel coupon);
    String generateKodeCoupon(CouponModel coupon, List<CouponTypeModel> couponValues);
}
