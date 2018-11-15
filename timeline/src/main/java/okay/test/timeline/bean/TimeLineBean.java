package okay.test.timeline.bean;

import okay.test.timeline.enu.OrderStatus;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/20 15:13
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class TimeLineBean {

    public String message;
    public String date;
    public OrderStatus status;

    public TimeLineBean(String message, String date, OrderStatus status) {
        this.message = message;
        this.date = date;
        this.status = status;
    }
}
