package controller;

import com.alibaba.fastjson.JSON;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z673413 on 2016/7/26.
 */
@Controller
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/page/loginCheck.json")
    @ResponseBody
    public String loginCheck(@RequestParam String inputAccount, @RequestParam String inputPassword,
                             HttpServletRequest request) {
        List<User> users = userService.findUser(inputAccount, inputPassword);
        Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
        if (users.size() == 0) {
            returnMap.put("respCode", "1001");
            returnMap.put("respMsg", "loginFail");
            request.getSession().setAttribute("loginUser", null);
        } else {
            returnMap.put("respCode", "1000");
            returnMap.put("respMsg", "loginSuccess");
            request.getSession().setAttribute("loginUser", users.get(0));
        }

        return JSON.toJSONString(returnMap);
    }

    @RequestMapping("/page/logout.json")
    @ResponseBody
    public void logout(HttpServletRequest request) {
        request.getSession().setAttribute("loginUser", null);
        logger.info("logout!");
    }
}
