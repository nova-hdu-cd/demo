package com.chendong.demo.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    /**
     * 工程id
     */
    private String projectId;

    /**
     * 领域空间
     */
    private String nameSpace;

    /**
     * 业务id
     */
    private String clientEntryId;

    /**
     * unisocId
     */
    private String unisocId;
}
