package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.rest.CouponDetail;

import java.util.List;

public interface CouponRestService {
    List<CouponDetail> getAllCoupon();
}
