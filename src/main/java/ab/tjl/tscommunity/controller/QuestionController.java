package ab.tjl.tscommunity.controller;

import ab.tjl.tscommunity.dto.QuestionDTO;
import ab.tjl.tscommunity.mapper.QuestionMapper;
import ab.tjl.tscommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:tangjilin
 * @Description:问题详情控制层
 * @Date:Created in 16:40 2019/8/26
 * @Modified By:
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
       QuestionDTO questionDTO = questionService.getById(id);
       model.addAttribute("question",questionDTO);
        return "question";
    }
}
