package ab.tjl.tscommunity.interceptor;

import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.User;
import ab.tjl.tscommunity.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:tangjilin
 * @Description:配置具体拦截实现
 * @Date:Created in 15:55 2019/8/26
 * @Modified By:
 */
@Service
public class SessionInterception implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie coolie : cookies) {
                if (coolie.getName().equals("token")) {
                    String token = coolie.getValue();
                    UserExample userExample = new UserExample();
                    userExample.createCriteria().andTokenEqualTo(token);

                    List<User> users = userMapper.selectByExample(userExample);
                    if (users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                    }
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
