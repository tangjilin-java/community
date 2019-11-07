package ab.tjl.tscommunity.interceptor;

import ab.tjl.tscommunity.enums.AdPosEnum;
import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.User;
import ab.tjl.tscommunity.model.UserExample;
import ab.tjl.tscommunity.service.AdService;
import ab.tjl.tscommunity.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private AdService adService;
    @Autowired
    private NotificationService notificationService;
    @Value(value = "${github.redirect.uri}")
    private String redirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //设置 context 级别的属性
        request.getServletContext().setAttribute("redirectUri",redirectUri);
        //没有登录的时候也可以看导航栏
        for (AdPosEnum adPos : AdPosEnum.values()) {
            request.getServletContext().setAttribute(adPos.name(),adService.list(adPos.name()));
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie coolie : cookies) {
                if (coolie.getName().equals("token")) {
                    String token = coolie.getValue();
                    UserExample userExample = new UserExample();
                    userExample.createCriteria().andTokenEqualTo(token);

                    List<User> users = userMapper.selectByExample(userExample);
                    if (users.size() != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", users.get(0));
                        Long unreadCount = notificationService.unreadCount(users.get(0).getId());
                        session.setAttribute("unreadCount",unreadCount);
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
