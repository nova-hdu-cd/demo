package com.chendong.demo.service.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chendong
 * @date 2020/6/19 5:01 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexReq {

    private String name;

    private String sex;

    private String phone;

}
