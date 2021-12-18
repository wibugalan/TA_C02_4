package C02_4.SIBUSINESS.controller;
import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.CouponDB;
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
    CouponDB couponDB;

    @Autowired
    CouponTypeService couponTypeService;

    @GetMapping("/viewall")
    public String listCoupon(Model model){
        List<CouponModel> listCoupon = couponDB.findAll();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon";
    }

    @GetMapping("/requestCreation")
    public String listRequest(Model model){
        List<CouponModel> listCoupon = couponDB.findAllByStatus(false);
        model.addAttribute("listAll", listCoupon);
        return "viewall-couponRequest";
    }

    @GetMapping("/detail")
    public String detailCoupon(
            @RequestParam(value="id") Long id,
            Model model
    ){
        CouponModel coupon = couponDB.getById(id);
        model.addAttribute("coupon", coupon);
        return "view-coupon";
    }

    @GetMapping("/update/{id}")
    private String updateCouponFormPage(
            @PathVariable Long id,
            Model model)
    {
        CouponModel coupon = couponService.getCouponById(id);
        List<CouponTypeModel> listCouponType = couponTypeService.getListCouponType();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userDB.findByUsername(authentication.getName());

        model.addAttribute("coupon", coupon);
        model.addAttribute("flag", coupon.isStatus());
        model.addAttribute("listCouponType", listCouponType);
        model.addAttribute("user", user);
        return "form-update-coupon";
    }

    @PostMapping("/update")
    private String updateCouponSubmit(
            @ModelAttribute CouponModel coupon,
            Model model
    ){
        couponService.updateCoupon(coupon);
        model.addAttribute("kodeCoupon", coupon.getCoupon_code());
        return "update-coupon";
    }
}
