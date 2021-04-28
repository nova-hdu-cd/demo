package com.chendong.demo.common.pojo.dto;

import lombok.*;

/**
 * 工单DTO
 *
 * @author chendong
 * @date 2020/7/21 10:15 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO extends BaseDTO {

    private String name;

    @NonNull
    private String id;

    @NonNull
    private Integer sex;

}
