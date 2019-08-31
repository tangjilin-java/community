package ab.tjl.tscommunity.controller;

import ab.tjl.tscommunity.dto.CommentDTO;
import ab.tjl.tscommunity.dto.QuestionDTO;
import ab.tjl.tscommunity.enums.CommentTypeEnum;
import ab.tjl.tscommunity.exception.CustomizeErrorCode;
import ab.tjl.tscommunity.exception.CustomizeException;
import ab.tjl.tscommunity.service.CommentService;
import ab.tjl.tscommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") String id,
                           Model model){
        Long questionId = null;
        try {
            questionId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }

       QuestionDTO questionDTO = questionService.getById(questionId);
       List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
       List<CommentDTO> comments = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);
       questionService.incView(questionId);//累加阅读数
       model.addAttribute("question",questionDTO);
       model.addAttribute("comments",comments);
       model.addAttribute("relatedQuestions",relatedQuestions);
        return "question";
    }
}
