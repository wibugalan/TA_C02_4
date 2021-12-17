package C02_4.SIBUSINESS.controller;
import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.CouponDB;
import C02_4.SIBUSINESS.repository.CouponTypeDB;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    CouponTypeDB couponTypeDB;

    @Autowired
    CouponTypeService couponTypeService;

    @GetMapping("/viewall")
    public String listCoupon(Model model){
        List<CouponModel> listCoupon = couponDB.findAll();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon";
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

    //  Add coupon get
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    private String addCouponFormPage(Model model){
        CouponModel coupon = new CouponModel();
        List<CouponTypeModel> listCouponType = couponTypeService.getListCouponType();
        model.addAttribute("listCouponType", listCouponType);
        model.addAttribute("coupon", coupon);
        return "form-add-coupon";
    }

    // Add coupon post
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addCouponSubmit(@ModelAttribute CouponModel coupon, Model model, @RequestParam List<CouponTypeModel> couponValues){
        coupon.setListCoupontype(couponValues);
        coupon.setCoupon_code("ADS");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userService.getUserByUsername(auth.getName());
        coupon.setCreator(user);

        if(auth.getAuthorities().toString().contains("[Staff_Marketing]") || auth.getAuthorities().toString().equalsIgnoreCase("[Staff Marketing]")){
            coupon.setStatus(true);
        } else if (auth.getAuthorities().toString().equalsIgnoreCase("[Staff_Product]") || auth.getAuthorities().toString().equalsIgnoreCase("[Staff Product]")){
            coupon.setStatus(false);
        }
        System.out.println(auth.getAuthorities().toString());

        couponService.addCoupon(coupon);

        model.addAttribute("coupon", coupon);

        return "redirect:/";
    }



}
