package ab.tjl.tscommunity.enums;

/**
 * @author:tangjilin
 * @Description:回复状态枚举类
 * @Date:Created in 15:34 2019/8/29
 * @Modified By:
 */
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
