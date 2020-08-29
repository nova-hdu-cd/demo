package com.chendong.demo.domian.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author chendong
 * @date 2020/6/5 9:47 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractPerson {

    @NonNull
    private String name;
    @NonNull
    private String id;

}
