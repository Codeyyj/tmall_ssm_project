package zsx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zsx.entity.Property;
import zsx.service.PropertyService;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_list")
        public ModelAndView findAll(int cid){
            //System.out.println("111");
            List<Property> list = propertyService.findAll(cid);
            //System.out.println(list);
            ModelAndView mv =new ModelAndView("/admin/listProperty");
            mv.addObject("property",list);
            mv.addObject("c",cid);
            return mv;
    }

    @RequestMapping("admin_property_update")
    public String update(Property property){
        propertyService.update(property);
        return "redirect:/admin_property_list?cid="+property.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id,int cid){
        propertyService.delete(id);
        return "redirect:/admin_property_list?cid="+cid;
    }
    @RequestMapping("admin_property_edit")
    public ModelAndView edit(int id,int cid){

        ModelAndView mv = new ModelAndView("admin/editProperty");
        mv.addObject("p",propertyService.findById(id));
        return mv;
    }
    @RequestMapping("admin_property_add")
    public String add(Property property){
       // System.out.println(property.toString());

        propertyService.add(property);
        return "redirect:/admin_property_list?cid="+property.getCid();
    }
}
