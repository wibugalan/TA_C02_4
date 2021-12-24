package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.model.RoleModel;
import C02_4.SIBUSINESS.service.RoleService;
import C02_4.SIBUSINESS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private String addUserSubmit(@ModelAttribute UserModel user, Model model, RedirectAttributes attributes){
        List<UserModel> listUser = userService.getUserList();
        for (UserModel Olduser:
                listUser) {

            if (user.getUsername().equals(Olduser.getUsername())){
                attributes.addFlashAttribute("notif", "Username yang anda masukkan sudah digunakan");
                return "redirect:/user/add";
            }

        }
        userService.addUser(user);
        model.addAttribute("user", user);
        return "add-user";
    }

    @GetMapping("/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/update")
    private String updateUserFormPage(
            @RequestParam(value = "id") String id,
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
            @RequestParam(value = "passLama") String passLama,
            @RequestParam(value = "passLamaForm") String passLamaForm,
            @RequestParam(value = "passBaru") String passBaru,
            Model model
    ){
        List<RoleModel> listRole = roleService.getListRole();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean cond = passwordEncoder.matches(passLamaForm, passLama);
        if (cond){
            if (passBaru.equals(user.getPassword())) {
                userService.addUser(user);
            }
            else {
                user.setPassword(passLama);
                model.addAttribute("passwordLama", false);
                model.addAttribute("passwordBaru", true);
                model.addAttribute("listRole", listRole);
                model.addAttribute("user", user);
                return "form-update-user";
            }
        }
        else {
            user.setPassword(passLama);
            model.addAttribute("passwordLama", true);
            model.addAttribute("passwordBaru", false);
            model.addAttribute("listRole", listRole);
            model.addAttribute("user", user);
            return "form-update-user";
        }
        return "redirect:/user/viewall";
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
