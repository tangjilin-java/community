package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:
 * @Date:Created in 9:28 2019/8/31
 * @Modified By:
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
