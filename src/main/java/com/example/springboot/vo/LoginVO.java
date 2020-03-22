package com.example.springboot.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 *用户名与密码只能用:
 *         数字,字母,下划线
 *         6-18位字符
 * @author Wei yuyaung
 * @date 2020.03.12 22:50
 */
@Data
public class LoginVO {
    @NotEmpty(message = "不能为空")
    @Length(min = 11,max = 11,message = "请输入11位号码")
    @Pattern(regexp="^[1]+[3,5,8]+\\d{9}$",message ="电话号码非法")
    private String phoneNumber;

    /**
     * 只能含有数字,字母和下划线
     */

    @NotEmpty(message = "不能为空")
    @Size(min = 6,max = 18,message = "用户名长度错误")
    @Pattern(regexp ="^\\w+$",message = "格式错误")
    private String userName;


    /**
     * 字母开头+数字或下划线
     */

    @NotBlank(message = "不能为空")
    @Size(min = 6,max = 18,message = "密码长度错误")
    @Pattern(regexp ="^[a-zA-Z]\\w+$",message = "格式错误")
    private String password;

}
