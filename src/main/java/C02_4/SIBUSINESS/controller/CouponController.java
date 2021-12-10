package C02_4.SIBUSINESS.controller;
import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.UserDB;
import C02_4.SIBUSINESS.service.CouponService;
import C02_4.SIBUSINESS.service.CouponTypeService;
import C02_4.SIBUSINESS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    UserService userService;

    @Autowired
    UserDB userDB;

    @Autowired
    CouponTypeService couponTypeService;

    @GetMapping("/update/{id}")
    private String updateCouponFormPage(
            @RequestParam(value = "id") Long id,
            Model model)
    {
        CouponModel coupon = couponService.getCouponById(id);
        List<CouponTypeModel> listCouponType = couponTypeService.getListCouponType();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userDB.findByUsername(authentication.getName());

        model.addAttribute("coupon", coupon);
        model.addAttribute("listCouponType", listCouponType);
        model.addAttribute("user", user);
        model.addAttribute("coupon", coupon);
        return "form-update-coupon";
    }

    @PostMapping("/update")
    private String updateCouponSubmit(
            @ModelAttribute CouponModel coupon,
            Model model
    ){
        couponService.updateCoupon(coupon);
        return "update-coupon";
    }
}
