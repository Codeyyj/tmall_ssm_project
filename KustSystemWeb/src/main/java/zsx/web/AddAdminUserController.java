package zsx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zsx.entity.adminUser;
import zsx.service.AddUserService;

import javax.servlet.http.HttpServletRequest;

@Controller  //控制层
@RequestMapping("")
public class AddAdminUserController {

    @Autowired
    private AddUserService ym;

    //登录
    /**
     * 登录账号
     * @return
     */

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        adminUser s = ym.login(username);
//        System.out.println(username);
//        System.out.println(password);
        ModelAndView mv = new ModelAndView();
        if(s != null){

            if(s.getPassword().equals(password)){
                mv.setViewName("admin/listCategory");//登录成功跳转listCategory_list
            }
            else {
                mv.addObject("user", "passerror");
                mv.setViewName("login");
            }
        }
        else{
            mv.addObject("user","notexit");
            mv.setViewName("login");
        }
        return mv;
    }

    //注册
    @RequestMapping("/register")
    public ModelAndView register(adminUser user){

        ModelAndView mv = new ModelAndView();
        System.out.println(user.getUsername());
        adminUser t = ym.login(user.getUsername());
        if(t != null){
            mv.addObject("user","exit");
            mv.setViewName("register");
        }
        else{
            ym.register(user);
            mv.setViewName("login");
        }
        return mv;
    }

}
