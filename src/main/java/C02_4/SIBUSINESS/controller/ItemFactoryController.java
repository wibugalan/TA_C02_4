package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.rest.ItemDetail;
import C02_4.SIBUSINESS.rest.ResultItemDetail;
import C02_4.SIBUSINESS.service.ItemFactoryRestService;
import C02_4.SIBUSINESS.service.ItemFactoryService;
import C02_4.SIBUSINESS.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemFactoryController {

    @Autowired
    private ItemFactoryRestService itemFactoryRestService;

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


    @GetMapping("/")
    public String listItem(Model model) throws JsonProcessingException {
        List<ResultItemDetail> listItem = itemFactoryRestService.item();
        model.addAttribute("listItem", listItem);
        return "viewall-item";
    }

    @GetMapping("/detail/{uuid}")
    public String viewDetailBarang(
            @PathVariable String uuid,
            Model model) throws JsonProcessingException {
        ResultItemDetail listItem = itemFactoryRestService.detailItem(uuid);
        model.addAttribute("listItem", listItem);
        return "view-item";



    }



}
