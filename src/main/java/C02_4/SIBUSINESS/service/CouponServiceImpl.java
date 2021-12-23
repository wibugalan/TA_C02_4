package C02_4.SIBUSINESS.service;
import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.repository.CouponDB;
import C02_4.SIBUSINESS.repository.CouponTypeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{
    @Autowired
    CouponDB couponDB;

    @Override
    public List<CouponModel> getListCoupon(){
        return couponDB.findAll();
    }

    @Override
    public CouponModel getCouponById(Long id){
        Optional<CouponModel> target = couponDB.findById(id);
        if(target.isPresent()){
            return target.get();
        }
        return null;
    }

    @Override
    public  void updateCoupon(CouponModel coupon){
        couponDB.save(coupon);
    }

    @Override
    public  void addCoupon(CouponModel coupon){
        couponDB.save(coupon);
    }

    @Override
    public CouponModel approveCoupon(Long id){
        CouponModel coupon = couponDB.getById(id);
        coupon.setStatus(true);
        return coupon;
    }

    @Override
    public void rejectCoupon(Long id){
        couponDB.deleteById(id);
    }

    @Override
    public void deleteCoupon(CouponModel coupon) {
        couponDB.delete(coupon);
    }

    @Override
    public String generateKodeCoupon(CouponModel coupon) {
        String out = "DISC";
        String discAmount = Integer.toString(Math.round(coupon.getDiscountAmount() * 100));
        if(discAmount.length()==1){
            out += "00" + discAmount;
        }
        else if(discAmount.length()==2){
            out += "0" + discAmount;
        }
        else{
            out += discAmount;
        }

        List<String> day = new ArrayList<>();
        if (!coupon.getListCoupontype().isEmpty()) {
            for(CouponTypeModel c: coupon.getListCoupontype()) {
                day.add(c.getUse_day());
            }

            if (day.contains("Sunday")) {
                out+="SUN";
            }
            else if (day.contains("Monday")) {
                out+="MON";
            }
            else if (day.contains("Tuesday")) {
                out+="TUE";
            }
            else if (day.contains("Wednesday")) {
                out+="WED";
            }
            else if (day.contains("Thursday")) {
                out+="THU";
            }
            else if (day.contains("Friday")) {
                out+="FRI";
            }
            else if (day.contains("Saturday")) {
                out += "SAT";
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String strDate = formatter.format(coupon.getExpiryDate());
        out += strDate.substring(0,4);
        out += strDate.substring(6);
        return out;
    }
}
