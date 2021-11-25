package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.service.RoleService;
import C02_4.SIBUSINESS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping("/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/update/{id}")
    private String updateUserFormPage(
            @PathVariable String id,
            Model model)
    {
        UserModel user = userService.getUserById(id);
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-update-user";
    }

    @PostMapping("/update")
    private String updateUserSubmit(
            @ModelAttribute UserModel user,
            Model model
    ){
        userService.addUser(user);
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

//    @GetMapping("/delete/{username}")
//    public String deleteUser(@PathVariable String username, Model model) {
//        UserModel user = userService.getUserByUsername(username);
//        userService.deleteUser(user);
//        model.addAttribute("user", user);
//        return "redirect:/user/viewall";
//    }

//    @RequestMapping(value = "/update-password", method = RequestMethod.GET)
//    private String updatePasswordForm(Model model){
//        model.addAttribute("text", "");
//        return "form-update-password";
//    }

//    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
//    private String updatePasswordSubmit(@RequestParam String oldPassword, String newPassword, String newPassword2, String username, Model model){
//        UserModel user = userService.getUserByUsername(username);
//        if(userService.checkMatch(oldPassword, user.getPassword())){
//            if(newPassword.equals(newPassword2)){
//                userService.updatePassword(user, newPassword);
//                model.addAttribute("pesan","Password berhasil diubah");
//            }
//            else{
//                model.addAttribute("pesan", "Password baru yang dimasukkan tidak sesuai");
//            }
//        }
//        else{
//            model.addAttribute("pesan", "Password lama yang dimasukkan salah");
//        }
//        return "form-update-password";
//    }



}
