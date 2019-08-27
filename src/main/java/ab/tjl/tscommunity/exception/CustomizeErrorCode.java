package ab.tjl.tscommunity.exception;

/**
 * @author:tangjilin
 * @Description:异常错误码统一处理
 * @Date:Created in 15:57 2019/8/27
 * @Modified By:
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND( "你找到问题不在了，要不要换个试试？");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
