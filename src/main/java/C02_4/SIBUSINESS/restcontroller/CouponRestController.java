package C02_4.SIBUSINESS.restcontroller;

import C02_4.SIBUSINESS.rest.CouponDetail;
import C02_4.SIBUSINESS.service.CouponRestService;
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

    @GetMapping(value = "/list-coupon")
    private List<CouponDetail> retrieveListCoupon() {
        return couponRestService.getAllCoupon();
    }
}
