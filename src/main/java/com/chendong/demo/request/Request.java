package com.chendong.demo.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dong.chen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable {

    private static final long serialVersionUID = -981083822382133284L;

    /**
     * 请求uuid
     */
    private String uuid;

    /**
     * projectId
     */
    private String projectId;

    /**
     * 请求名字
     */
    private String name;

}
