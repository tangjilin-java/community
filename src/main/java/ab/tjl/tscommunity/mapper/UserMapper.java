package ab.tjl.tscommunity.mapper;

import ab.tjl.tscommunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:tangjilin
 * @Description:用户映射
 * @Date:Created in 9:03 2019/8/25
 * @Modified By:
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
