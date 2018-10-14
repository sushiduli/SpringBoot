package com.example.demo.controller;


import com.example.demo.config.ShiroConfiguration;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Levin
 * @since 2018/6/28 0028
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfiguration.class);

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String loginPage() {
        log.info("进入登录页面...");
        return "/loginPage";
    }

    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String logout() {
        log.info("进入登录页面...");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/loginPage";
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String login(String username, String password, RedirectAttributes model) {
        // 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟 shiro 的拦截地址内．不然后会报空指针
        Subject sub = SecurityUtils.getSubject();
        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
        // 认证执行者交由 com.battcn.config.AuthRealm 中 doGetAuthenticationInfo 处理
        // 当以上认证成功后会向下执行,认证失败会抛出异常
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            sub.login(token);
        } catch (UnknownAccountException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
            token.clear();
            return "loginPage";
        } catch (LockedAccountException lae) {
            log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", username);
            token.clear();
            return "loginPage";
        } catch (ExcessiveAttemptsException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", username);
            token.clear();
            return "loginPage";
        } catch (AuthenticationException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", username, e);
            token.clear();
            return "loginPage";
        }
        return "index";
    }
}