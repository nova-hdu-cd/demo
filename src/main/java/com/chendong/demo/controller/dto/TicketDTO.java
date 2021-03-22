package com.chendong.demo.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @author chendong
 * @date 2020/7/21 10:15 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class TicketDTO extends BaseDTO {

    private String name;

    @NonNull
    private String id;

    @NonNull
    private Integer sex;

}
