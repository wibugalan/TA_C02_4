package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.UserModel;
import java.util.List;

public interface UserService {
//    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getUserList();
    UserModel getUserByUsername(String username);

    void addUser(UserModel user);
    UserModel getUserById(String id);
//    void deleteUser(UserModel user);
//    void updatePassword(UserModel user, String password);
//    boolean checkMatch(String oldPassword, String newPassword);
}
