package controller;

import annotation.LogAnnotation;
import com.alibaba.fastjson.JSON;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import util.RSAUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by z673413 on 2016/7/26.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/page/loginCheck.json")
    @ResponseBody
    @LogAnnotation
    public String loginCheck(@RequestParam String inputAccount, @RequestParam String inputPassword,
                             HttpServletRequest request) throws Exception {
        inputAccount = RSAUtil.decrypt(inputAccount, RSAUtil.PRIVATE_KEY);
        inputPassword = RSAUtil.decrypt(inputPassword, RSAUtil.PRIVATE_KEY);
        User user = userService.findUser(inputAccount, inputPassword);
        Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
        if (user.getId() == null) {
            returnMap.put("respCode", "1001");
            returnMap.put("respMsg", "loginFail");
            request.getSession().setAttribute("loginUser", null);
        } else {
            returnMap.put("respCode", "1000");
            returnMap.put("respMsg", "loginSuccess");
            request.getSession().setAttribute("loginUser", user);
        }

        return JSON.toJSONString(returnMap);
    }

    @RequestMapping("/page/logout.json")
    @ResponseBody
    @LogAnnotation
    public String logout(HttpServletRequest request) {
        Map<String, Object> returnMap = new LinkedHashMap<String, Object>();

        request.getSession().setAttribute("loginUser", null);
        returnMap.put("respCode", "1000");
        returnMap.put("respMsg", "注销成功");//.getBytes("UTF-8"),"iso8859-1");

        return JSON.toJSONString(returnMap);
    }
}
