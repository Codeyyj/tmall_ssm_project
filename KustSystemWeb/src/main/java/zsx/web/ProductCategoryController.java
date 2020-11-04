package zsx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zsx.dao.PropertyValueDao;
import zsx.entity.ProdctCategory;
import zsx.entity.PropertyValue;
import zsx.service.ProductCategoryService;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService pc;

    @RequestMapping("admin_product_list")
    public ModelAndView findAll (int cid){
        ModelAndView mv =new ModelAndView("/admin/listProduct");
        List list = pc.findAll(cid);
        mv.addObject("ps",list);
        mv.addObject("c",cid);
        return mv;
    }
    @RequestMapping("admin_product_add")
    public String add(ProdctCategory prodctCategory){
        //prodctCategory.toString();
        pc.add(prodctCategory);
        return "redirect:/admin_product_list?cid="+prodctCategory.getCid();
    }
    @RequestMapping("admin_product_delete")
    public String delete(int id,int cid){
        pc.delete(id);
        return "redirect:/admin_product_list?cid="+cid;
    }
    @RequestMapping("admin_product_edit")
    public ModelAndView edit(int id){
        ModelAndView mv = new ModelAndView("/admin/editProduct");
        ProdctCategory prodctCategory= pc.findById(id);

        mv.addObject("p",prodctCategory);
        mv.addObject("c",prodctCategory.getCid());
        return mv;
    }
    @RequestMapping("admin_product_update")
    public String update( ProdctCategory prodctCategory){
        System.out.println("111");
        System.out.println(prodctCategory);
        pc.update(prodctCategory);
        return "redirect:/admin_product_list?cid="+prodctCategory.getCid();
    }
    @RequestMapping("admin_propertyValue_edit")
    public ModelAndView initPropertyValue(int ptid){
        //获取cid ,返回一个PropertyValue集合
        List<PropertyValue> list=pc.init(ptid);
        ModelAndView mv = new ModelAndView("/admin/editPropertyValue");
        mv.addObject("propertyValueList",list);
        return mv;
    }
}
