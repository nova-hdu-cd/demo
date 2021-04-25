package com.chendong.demo.service.responce;


import com.chendong.demo.common.enums.global.ResultCode;
import com.chendong.demo.common.response.R;

/**
 * @author dong.chen
 */
public class IndexResponse extends R {

    private String id;
    private String uuid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public IndexResponse(String id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public IndexResponse() {
    }

    public IndexResponse(ResultCode resultCode, Object data, String id, String uuid) {
        super(resultCode, data);
        this.id = id;
        this.uuid = uuid;
    }
}
