package ab.tjl.tscommunity.dto;

import ab.tjl.tscommunity.model.User;
import lombok.Data;

/**
 * @author:tangjilin
 * @Description:评论数据传输
 * @Date:Created in 9:18 2019/8/28
 * @Modified By:
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
