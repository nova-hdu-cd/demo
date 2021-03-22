package com.chendong.demo.service.responce;


import com.chendong.demo.response.BaseResponse;

public class IndexResponse extends BaseResponse<String> {

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


    @Override
    public String toString() {
        return "IndexResponse{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
