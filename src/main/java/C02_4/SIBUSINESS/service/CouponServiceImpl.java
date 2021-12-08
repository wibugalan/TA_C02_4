package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.repository.CouponDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public List<CouponModel> getListCouponRequest(){
        return couponDB.findAllByStatus(false);
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
    public CouponModel updateStatus(Long id){
        Optional<CouponModel> target = couponDB.findById(id);
        if(target.isPresent()){
            CouponModel coupon =  target.get();
            coupon.setStatus(true);
            return coupon;
        }
        return null;
    }
}
