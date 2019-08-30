package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:搜索数据
 * @Date:Created in 14:10 2019/8/30
 * @Modified By:
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String sort;
    private Long time;
    private String tag;
    private Integer page;
    private Integer size;
}
