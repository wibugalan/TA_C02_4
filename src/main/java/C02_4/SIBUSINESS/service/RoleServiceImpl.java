package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.repository.RoleDB;
import C02_4.SIBUSINESS.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDB roleDB;

    @Override
    public List<RoleModel> getListRole() {
        return roleDB.findAll();
    }
}

