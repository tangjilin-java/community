package ab.tjl.tscommunity.dto;

import ab.tjl.tscommunity.exception.CustomizeErrorCode;
import ab.tjl.tscommunity.exception.CustomizeException;
import lombok.Data;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author:tangjilin
 * @Description:异常信息返回结果
 * @Date:Created in 15:30 2019/8/27
 * @Modified By:
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;
   // private T data;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
}