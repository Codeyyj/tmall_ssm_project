package zsx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zsx.dao.userDao;
import zsx.entity.User;
import zsx.service.UserServie;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
@Autowired
UserServie us;
@RequestMapping("admin_user_list")
    public ModelAndView findAll(){

    ModelAndView mv = new ModelAndView("/admin/listUser");
    mv.addObject("us",us.findAll());

    return  mv;
}
@RequestMapping("admin_user_update")

public String update(User user){
    us.update(user);
    return "redirect:/admin_user_list";

}

@RequestMapping("admin_user_edit")
    public ModelAndView edit(int id){
    ModelAndView mv = new ModelAndView("admin/editUser");
    mv.addObject("user",us.findById(id));
    return mv;
}

    @RequestMapping("admin_user_delete")
    public String delete(int id)  {
        //1，测试一下能不能具体拿到id值
        //2，调用业务层（然后业务层又去调用持久层，发送一个delect语句
        us.DeleteById(id);
        //3，重定向到查询请求
        return "redirect:admin_user_list";  //重定向
    }
}
