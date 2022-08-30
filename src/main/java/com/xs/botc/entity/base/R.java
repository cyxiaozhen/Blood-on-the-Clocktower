//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.xs.botc.entity.base;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 返回实体
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/3 周三
 */
@ApiModel(
        description = "返回结果"
)
public class R<T> implements Serializable {
    @ApiModelProperty(
            value = "状态码",
            required = false
    )
    private String code;
    @ApiModelProperty(
            value = "返回消息",
            required = false
    )
    private String msg;
    @ApiModelProperty(
            value = "返回数据",
            required = false
    )
    private T data;
    static JSONObject emptyJson = new JSONObject();

    public R() {
    }

    public static <T> R ok() {
        return ok(R.ResultEnum.SUCCESS.code, R.ResultEnum.SUCCESS.msg);
    }

    public static <T> R ok(String msg) {
        return ok(R.ResultEnum.SUCCESS.code, msg);
    }

    public static <T> R ok(T data) {
        return ok(R.ResultEnum.SUCCESS.code, R.ResultEnum.SUCCESS.msg, data);
    }

    public static <T> R ok(String code, String msg) {
        return ok(code, msg, emptyJson);
    }

    public static <T> R ok(String code, String msg, T data) {
        return info(code, msg, data);
    }

    public static <T> R error() {
        return error(R.ResultEnum.FAILURE.code, R.ResultEnum.FAILURE.msg);
    }

    public static <T> R error(String msg) {
        return error(R.ResultEnum.FAILURE.code, msg);
    }

    public static <T> R error(T data) {
        return error(R.ResultEnum.FAILURE.code, R.ResultEnum.FAILURE.msg, data);
    }

    public static <T> R error(String code, String msg) {
        return error(code, msg, emptyJson);
    }

    public static <T> R error(String code, String msg, T data) {
        return info(code, msg, data);
    }

    public static <T> R info(String code, String msg, T data) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        if (null == data) {
            r.setData(emptyJson);
        } else if (data instanceof String) {
            List<String> list = new ArrayList();
            list.add(data.toString());
            r.setData(list);
        }

        return r;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof R;
    }

    @Override
    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    public static enum ResultEnum {
        SUCCESS("0", "操作成功"),
        FAILURE("1", "操作失败");

        public String code;
        public String msg;

        private ResultEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
