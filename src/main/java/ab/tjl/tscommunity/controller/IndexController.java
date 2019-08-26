package ab.tjl.tscommunity.controller;

import ab.tjl.tscommunity.dto.PaginationDTO;
import ab.tjl.tscommunity.dto.QuestionDTO;
import ab.tjl.tscommunity.mapper.QuestionMapper;
import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.Question;
import ab.tjl.tscommunity.model.User;
import ab.tjl.tscommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:tangjilin
 * @Description:首页控制层
 * @Date:Created in 17:18 2019/8/24
 * @Modified By:
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "2") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0 ){
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
        }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
