package top.ysqorz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author passerbyYSQ
 * @create 2022-08-17 22:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(200, "OK", data);
    }
}
