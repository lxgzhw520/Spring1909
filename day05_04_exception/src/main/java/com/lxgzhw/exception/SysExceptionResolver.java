package com.lxgzhw.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        //1.获取到异常对象
        //2.判断异常对象
        SysException ex = null;
        if (e instanceof SysException) {
            ex = (SysException) e;
        } else {
            ex = new SysException("系统正在维护...");
        }

        //3.创建ModelAndView对象mv
        ModelAndView mv = new ModelAndView();

        //4.获取提示信息,并设置给mv
        mv.addObject("errorMsg", ex.getMessage());

        //5.设置mv的跳转页面
        mv.setViewName("error");

        //6.返回mv
        return mv;
    }
}
