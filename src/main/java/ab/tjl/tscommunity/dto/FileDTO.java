package ab.tjl.tscommunity.dto;

import lombok.Data;

/**
 * @author:tangjilin
 * @Description:文件传输
 * @Date:Created in 10:01 2019/8/30
 * @Modified By:
 */
@Data
public class FileDTO {
    private int success;
    private String message;
    private String url;
}