package ab.tjl.tscommunity.exception;

/**
 * @author:tangjilin
 * @Description:异常通知类
 * @Date:Created in 15:44 2019/8/27
 * @Modified By:
 */
public class CustomizeException extends RuntimeException{
    private String message;

    //private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
       // this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

   /* public Integer getCode() {
        return code;
    }*/
}
