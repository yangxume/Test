package com.xy.t_net.utils;

import java.util.UUID;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-06 15:22
 * @Desc:
 */
public class RequestParamsUtil {

    public RequestParamsUtil() {
    }

    public static String newRequestId() {
        return String.format("03%010d", Math.abs(UUID.randomUUID().hashCode()));
    }

}
