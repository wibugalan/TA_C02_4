package C02_4.SIBUSINESS.service;


import C02_4.SIBUSINESS.model.CouponTypeModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.CouponTypeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CouponTypeServiceImpl implements CouponTypeService{
    @Autowired
    CouponTypeDB couponTypeDB;

    @Override
    public List<CouponTypeModel> getListCouponType(){
        return couponTypeDB.findAll();
    }

}