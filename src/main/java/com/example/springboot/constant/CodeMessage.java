package com.example.springboot.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Getter
@Setter
public class CodeMessage {

    public static final Integer PARAM_ERROR = 1;
    public static final CodeMessage SUCCESS = new CodeMessage(200, "成功");
    public static final CodeMessage GENERATE_CAPTCHA_FAIL = new CodeMessage(2, "生成验证码失败");
    public static final CodeMessage CLOSE_IMAGE_OUTPUT_STREAM_FAIL = new CodeMessage(3, "关闭图像流失败");
    public static final CodeMessage USER_ACCOUNT_LOCKED = new CodeMessage(4,"该账号已被冻结");
    public static final CodeMessage BAD_REQUEST = new CodeMessage(400,"请求参数有误");
    public static final CodeMessage INTERNAL_SERVER_ERROR = new CodeMessage(500, "服务器内部错误");

    public static final CodeMessage USER_NOT_EXIST = new CodeMessage(1001, "用户不存在");
    public static final CodeMessage INCORRECT_VERIFICATION_CODE = new CodeMessage(1002, "验证码错误");
    public static final CodeMessage SAME_USER_ACCOUNT = new CodeMessage(1003, "该用户名已经被使用");
    public static final CodeMessage ERROR_VERIFICATION = new CodeMessage(1004, "验证码不正确");
    public static final CodeMessage ERROR_MODIFY_USER_INFO = new CodeMessage(1005,"修改用户信息失败");
    public static final CodeMessage ENTER_OLD_PASSWORD_ERROR = new CodeMessage(1006,"输入的旧密码不正确");
    private Integer code;
    private String message;

    public CodeMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}