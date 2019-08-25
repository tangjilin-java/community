package ab.tjl.tscommunity.model;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:问题实体类
 * @Date:Created in 13:56 2019/8/25
 * @Modified By:
 */
@Data
public class Question {
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
}
