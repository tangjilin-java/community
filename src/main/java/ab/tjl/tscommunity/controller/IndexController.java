package ab.tjl.tscommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:tangjilin
 * @Description:
 * @Date:Created in 17:18 2019/8/24
 * @Modified By:
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
