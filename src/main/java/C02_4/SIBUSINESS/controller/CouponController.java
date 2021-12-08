package C02_4.SIBUSINESS.controller;


import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CouponController {

    @Autowired
    CouponService couponService;


    @GetMapping("coupon/viewallRequest")
    public String liatDaftarCouponRequest(Model model){
        List<CouponModel> hasil = couponService.getListCouponRequest();
        model.addAttribute("listAll", hasil);
        return "viewall-couponRequest";
    }

    @GetMapping("coupon/setuju-status")
    public String ubahStatus(
            @RequestParam(value = "id") Long id,
            Model model
    ){
        CouponModel target = couponService.getCouponById(id);
        CouponModel hasil = couponService.updateStatus(id);
        return "viewall-couponRequest";
    }

    @GetMapping("coupon/view")
    public String detailCoupon(
            @RequestParam(value = "id") Long id,
            Model model
    ){
        CouponModel target = couponService.getCouponById(id);
        model.addAttribute("coupon", target);
        return "detail-coupon";
    }
}
