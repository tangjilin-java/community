package ab.tjl.tscommunity.mapper;

import ab.tjl.tscommunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:tangjilin
 * @Description:
 * @Date:Created in 13:54 2019/8/25
 * @Modified By:
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
