package C02_4.SIBUSINESS.restcontroller;

import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.rest.CouponDetail;
import C02_4.SIBUSINESS.service.CouponRestService;
import C02_4.SIBUSINESS.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
public class CouponRestController {
    @Autowired
    CouponRestService couponRestService;

    @Autowired
    CouponService couponService;

    @GetMapping(value = "/list-coupon")
    private List<CouponDetail> retrieveListCoupon() {
        for (CouponModel c : couponService.getListCoupon()) {
            c.setCoupon_code(couponService.generateKodeCoupon(c));
        }
        return couponRestService.getAllCoupon();
    }
}
