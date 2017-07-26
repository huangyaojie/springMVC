/**
 *
 */
package cn.itcast.ssm.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.ssm.po.User;
import cn.itcast.ssm.service.UserService;
import cn.itcast.ssm.utils.Const;
import cn.itcast.ssm.utils.UserCookieUtil;


/**
 * [登录控制器]。<P>
 * [继承基类控制器，提供登录验证的方法。]
 *
 * @version 1.0
 * @author zhaoteng
 * @Date 2017/03/06 8:21:22
 */
@Controller
public class SystemController extends BaseController {
	private static final Logger logger = LogManager.getLogger("SystemController");
    @Resource
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        logger.info("返回首页！");
        return "index";
    }
//( @RequestParam(value = "number", defaultValue = PAGE_NUM)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response,
            @RequestParam String userName, @RequestParam String userPsd,
            @RequestParam(defaultValue = "false") String autologinch) throws Exception{
        try {
     	//通过济南的id号查找用户
        	if(null!=userName &&null!=userPsd){
        		User user = userService.findUserByNameAndPsd(userName,userPsd);
                if (user == null) {
                    logger.info("用户名或密码错误！！！");
          //          String str= SpringUtil.getApplicationContext().getMessage("message.usernameandpsd", null,null);
                    request.getSession().setAttribute("message","用户名或密码错误");
                    return "welcome";
                }else {
                        if(autologinch!=null && autologinch.equals("true")){ // 判断是否要添加到cookie中
                            // 保存用户信息到cookie
                            UserCookieUtil.saveCookie(user, response);
                        }
                        // 保存用信息到session
                        request.getSession().setAttribute(Const.SESSION_USER, user);
                }
        	}else{
        		//
        //		String str= SpringUtil.getApplicationContext().getMessage("message.user", null,null);
                request.getSession().setAttribute("message","用户名或密码为空");
                return "welcome";
        	}

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        //跳转至访问页面
        return "login";
        }





    /**
     * 用户注销
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session,HttpServletResponse response) {
        session.removeAttribute(Const.SESSION_USER);
        UserCookieUtil.clearCookie(response);
        logger.info("用户注销");
        return "redirect:/";
    }
}