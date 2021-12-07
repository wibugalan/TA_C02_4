package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;

import java.util.List;

public interface CouponService {
    List<CouponModel> getListCoupon();
    List<CouponModel> getListCouponRequest();
    CouponModel getCouponById(Long id);
    CouponModel updateStatus(Long id);
}
