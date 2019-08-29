package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:通知数据传输类
 * @Date:Created in 16:13 2019/8/29
 * @Modified By:
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
