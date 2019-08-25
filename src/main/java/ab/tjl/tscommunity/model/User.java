package ab.tjl.tscommunity.model;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:用户模型
 * @Date:Created in 9:06 2019/8/25
 * @Modified By:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
