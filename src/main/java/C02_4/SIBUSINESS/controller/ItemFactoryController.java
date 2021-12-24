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

import java.util.ArrayList;
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
        List<ResultItemDetail> listItem1 = itemFactoryRestService.itemByCategory("1");
        List<ResultItemDetail> listItem2 = itemFactoryRestService.itemByCategory("2");
        List<ResultItemDetail> listItem3 = itemFactoryRestService.itemByCategory("3");
        List<ResultItemDetail> listItem4 = itemFactoryRestService.itemByCategory("4");
        List<ResultItemDetail> listItem5 = itemFactoryRestService.itemByCategory("5");
        List<ResultItemDetail> listItem6 = itemFactoryRestService.itemByCategory("6");
        List<ResultItemDetail> listItem7 = itemFactoryRestService.itemByCategory("7");
        List<ResultItemDetail> listItem8 = itemFactoryRestService.itemByCategory("8");
        List<ResultItemDetail> listItem9 = itemFactoryRestService.itemByCategory("9");
        List<ResultItemDetail> listItem10 = itemFactoryRestService.itemByCategory("10");
        List<ResultItemDetail> listItem11 = itemFactoryRestService.itemByCategory("11");
        List<ResultItemDetail> listItem12 = itemFactoryRestService.itemByCategory("12");
        List<ResultItemDetail> listItem13 = itemFactoryRestService.itemByCategory("13");
        List<ResultItemDetail> listItem14 = itemFactoryRestService.itemByCategory("14");

        // Get kategori
        List<String> listKategori = new ArrayList<String>();
        for (ResultItemDetail itr : listItem) {
            String kategori = itr.getKategori();
            itr.setKategori(kategori);
            if (!listKategori.contains(kategori)){
                listKategori.add(kategori);
            }
        }
        // Print category
//        for(String x : listKategori){
//            System.out.println(x);
//        }

        // get per category
//        for(String x : listKategori){
//
//        }

        model.addAttribute("listItem1", listItem1);
        model.addAttribute("listItem2", listItem2);
        model.addAttribute("listItem3", listItem3);
        model.addAttribute("listItem4", listItem4);
        model.addAttribute("listItem5", listItem5);
        model.addAttribute("listItem6", listItem6);
        model.addAttribute("listItem7", listItem7);
        model.addAttribute("listItem8", listItem8);
        model.addAttribute("listItem9", listItem9);
        model.addAttribute("listItem10", listItem10);
        model.addAttribute("listItem11", listItem11);
        model.addAttribute("listItem12", listItem12);
        model.addAttribute("listItem13", listItem13);
        model.addAttribute("listItem14", listItem14);

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
