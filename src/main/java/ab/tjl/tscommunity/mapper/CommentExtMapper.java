package ab.tjl.tscommunity.mapper;

import ab.tjl.tscommunity.model.Comment;

/**
 * @author:tangjilin
 * @Description:扩展方法
 * @Date:Created in 22:02 2019/8/28
 * @Modified By:
 */
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}