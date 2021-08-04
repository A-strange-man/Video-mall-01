package com.example.online_class.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonData {

    // 状态码：0 成功，1 处理中，-1 失败
    private Integer code;

    // 业务数据
    private Object data;

    // 信息描述
    private String msg;

    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }
}
