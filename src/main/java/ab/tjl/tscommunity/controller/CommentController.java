package ab.tjl.tscommunity.controller;

import ab.tjl.tscommunity.dto.CommentDTO;
import ab.tjl.tscommunity.dto.ResultDTO;
import ab.tjl.tscommunity.exception.CustomizeErrorCode;
import ab.tjl.tscommunity.mapper.CommentMapper;
import ab.tjl.tscommunity.model.Comment;
import ab.tjl.tscommunity.model.User;
import ab.tjl.tscommunity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:tangjilin
 * @Description:评论信息控制层
 * @Date:Created in 9:14 2019/8/28
 * @Modified By:
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
