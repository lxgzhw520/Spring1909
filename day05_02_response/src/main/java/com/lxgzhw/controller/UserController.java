package com.lxgzhw.controller;

import com.lxgzhw.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回String类型的响应
     *
     * @param model spring封装的模型
     * @return 页面
     */
    @RequestMapping("/string")
    public String string(Model model) {
        User user = new User();
        user.setUsername("楚枫");
        user.setPassword("cufeng");
        user.setAge(33);
        //把model对象传给前端
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 测试ModelAndView的用法
     *
     * @return mv对象
     */
    @RequestMapping("/mv")
    public ModelAndView mv() {
        //1.创建ModelAndView对象mv
        ModelAndView mv = new ModelAndView();

        //2.模拟从数据库中查询出user对象
        User user = new User("楚枫", "cufeng", 33);

        //3.将对象存储到mv对象中
        mv.addObject("user", user);

        //4.指定跳转到哪个页面
        mv.setViewName("success");

        //5.返回mv对象
        return mv;
    }

    /**
     * 测试转发和重定向
     *
     * @return 转发或重定向的结果
     */
    @RequestMapping("/redirect")
    public String redirect() {
        //1.转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //2.重定向
        //2.1 注意:重定向不支持访问/WEB-INF/下面的资源
        return "redirect:/index.jsp";

    }

    @RequestMapping("/ajax")
    public @ResponseBody
    User ajax(User user) {
        System.out.println(user);
        return user;
    }
}
