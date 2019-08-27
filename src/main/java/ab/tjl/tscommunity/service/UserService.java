package ab.tjl.tscommunity.service;

import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.User;
import ab.tjl.tscommunity.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:tangjilin
 * @Description:用户业务层
 * @Date:Created in 19:16 2019/8/26
 * @Modified By:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
       if (users.size() == 0){
           //插入用户
           user.setGmtCreate(System.currentTimeMillis());
           user.setGmtModified(user.getGmtCreate());
           userMapper.insert(user);
       }else {
           //更新用户
           User dbUser = users.get(0);

           User updateUser = new User();
           updateUser.setGmtModified(System.currentTimeMillis());
           updateUser.setAvatarUrl(user.getAvatarUrl());
           updateUser.setName(user.getName());
           updateUser.setToken(user.getToken());
           UserExample example = new UserExample();
           example.createCriteria().andIdEqualTo(dbUser.getId());
           userMapper.updateByExampleSelective(updateUser, example);
       }
    }
}
