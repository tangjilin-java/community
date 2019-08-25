package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:把GitHub用户参数封装成一个对象传输层
 * @Date:Created in 16:49 2019/8/24
 * @Modified By:
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
