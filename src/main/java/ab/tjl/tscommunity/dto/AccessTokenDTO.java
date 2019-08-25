package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:把认证参数封装成一个对象传输层
 * @Date:Created in 16:12 2019/8/24
 * @Modified By:
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
