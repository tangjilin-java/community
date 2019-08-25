package ab.tjl.tscommunity.dto;

import ab.tjl.tscommunity.model.User;
import lombok.Data;

/**
 * @author:tangjilin
 * @Description:问题传输层：用于调用用户头像
 * @Date:Created in 16:21 2019/8/25
 * @Modified By:
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
