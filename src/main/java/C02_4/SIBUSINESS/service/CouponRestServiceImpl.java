package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.repository.CouponDB;
import C02_4.SIBUSINESS.repository.CouponTypeDB;
import C02_4.SIBUSINESS.rest.CouponDetail;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CouponRestServiceImpl implements  CouponRestService{
    @Autowired
    private CouponDB couponDB;

    public List<CouponDetail> getAllCoupon() {
        List<CouponModel> listCoupon = couponDB.findAll();
        List<CouponDetail> listDto = new ArrayList<>();
        String day = LocalDate.now().getDayOfWeek().name();
        System.out.println(day);
        for (CouponModel i : listCoupon) {
            List<CouponTypeModel> listCouponType = i.getListCoupontype();
            for (CouponTypeModel c: listCouponType) {
                if (c.getUse_day().equalsIgnoreCase(day)) {
                    CouponDetail coupon = new CouponDetail();
                    coupon.setId(i.getId());
                    coupon.setCoupon_code(i.getCoupon_code());
                    coupon.setCoupon_name((i.getCoupon_name()));
                    coupon.setDiscountAmount(i.getDiscountAmount());
                    coupon.setExpiryDate(i.getExpiryDate());
                    listDto.add(coupon);
                    break;
                }
            }
        }

        return listDto;
    }
}
