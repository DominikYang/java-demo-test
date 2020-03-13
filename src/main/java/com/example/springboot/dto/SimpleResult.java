package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 仅测试使用，后期删除
 * @author Wei yuyaung
 * @date 2020.03.13 23:56
 */
@Data
@AllArgsConstructor
public class SimpleResult implements Serializable {
    private boolean success;
}
