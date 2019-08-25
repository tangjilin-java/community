package ab.tjl.tscommunity.controller;

import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:tangjilin
 * @Description:
 * @Date:Created in 17:18 2019/8/24
 * @Modified By:
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie coolie:cookies) {
            if (coolie.getName().equals("token")){
                String token = coolie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
