package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public void addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        userDB.save(user);
    }

    @Override
    public List<UserModel> getUserList() {
        return userDB.findAll();
    }


    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel user = userDB.findByUsername(username);
        return user;
    }

//    @Override
//    public void deleteUser (UserModel user) {
//        userDB.delete(user);
//    }
//
//    @Override
//    public void updatePassword(UserModel user, String password) {
//        String pass = encrypt(password);
//        user.setPassword(pass);
//        userDB.save(user);
//    }
//
//    @Override
//    public boolean checkMatch(String newPassword, String oldPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(newPassword, oldPassword);
//    }

}
