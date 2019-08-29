package ab.tjl.tscommunity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author:tangjilin
 * @Description:标签数据传输
 * @Date:Created in 13:57 2019/8/29
 * @Modified By:
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}

