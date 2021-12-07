package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.service.ItemFactoryService;
import C02_4.SIBUSINESS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemFactoryController {

    @Autowired
    private ItemFactoryService itemFactoryService;

    @GetMapping("/requestItem")
    public String listRequestItem(
            Model model
    ){
        List<ItemFactoryModel> listRequest = itemFactoryService.getItemRequestList();
        model.addAttribute("listAll", listRequest);
        return "request-item";
    }

}
