package ab.tjl.tscommunity.service;

import ab.tjl.tscommunity.enums.CommentTypeEnum;
import ab.tjl.tscommunity.exception.CustomizeErrorCode;
import ab.tjl.tscommunity.exception.CustomizeException;
import ab.tjl.tscommunity.mapper.CommentMapper;
import ab.tjl.tscommunity.mapper.QuestionExtMapper;
import ab.tjl.tscommunity.mapper.QuestionMapper;
import ab.tjl.tscommunity.model.Comment;
import ab.tjl.tscommunity.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:tangjilin
 * @Description:评论信息业务层
 * @Date:Created in 9:46 2019/8/28
 * @Modified By:
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
