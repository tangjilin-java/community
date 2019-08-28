package ab.tjl.tscommunity.mapper;


import ab.tjl.tscommunity.model.Question;

/**
 * @author:tangjilin
 * @Description:问题详情控制层
 * @Date:Created in 16:56 2019/8/27
 * @Modified By:
 */
public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}