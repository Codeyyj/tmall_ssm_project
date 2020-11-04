package zsx.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zsx.entity.Product;
import zsx.service.ProductCategoryService;
import zsx.service.ProductService;
import zsx.service.PropertyService;
import zsx.util.ImageUtil;
import zsx.util.Page;
import zsx.util.UploadedImageFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("")
public class ProductController {
    //可以理解为这里自动new了一个对象
    @Autowired
    private ProductService ps;

    @Autowired
    private PropertyService propertyService;
    @Autowired
    ProductCategoryService productCategoryService;


    @RequestMapping("listCategory_list")
    public ModelAndView findAll(Page page){

        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> cs= ps.findAll();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        ModelAndView mv = new ModelAndView();
        //调用业务层获取数据
        mv.addObject("cs",cs);
        mv.addObject("page",page);
        //获取的数据一定是集合list<>,绑定到某个页面
        mv.setViewName("admin/listCategory");
        //通过该请求告诉springmvc应该去打开到哪个页面
        return mv;
    }
@RequestMapping("admin_category_delete")

    public String deleteById(int id,HttpSession session){
    //删除属性
        propertyService.deleteByCid(id);
        //删除产品
        productCategoryService.dleteBycid(id);
    //删除分类
        ps.deleteById(id);
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return "redirect:/listCategory_list";

    }
    //重定向：两个独立的请求之间跳转

    //转发：指的是在一个独立请求中，由控制层转发到页面传输数据的过程

    @RequestMapping("admin_category_add")
    public String add(Product product , HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {

            ps.add(product);
            File imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            List<Product> list = ps.findAll();
            Product p =list.get(ps.total()-1);
            File file = new File(imageFolder,p.getId()+".jpg");
            if(!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            uploadedImageFile.getImage().transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        return "redirect:/listCategory_list";
    }
    @RequestMapping("admin_category_edit")
    public ModelAndView edit(int id){
        ModelAndView mv =new ModelAndView();
        Product p =ps.findById(id);
        mv.addObject("product",p);
        mv.setViewName("/admin/editCategory");
        return mv;
    }

    @RequestMapping("admin_category_update")
    public String update(Product product,HttpSession session,UploadedImageFile uploadedImageFile) throws IOException {
        //System.out.println(product.getName());
        ps.update(product);
        File imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,product.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/listCategory_list";
    }




}
