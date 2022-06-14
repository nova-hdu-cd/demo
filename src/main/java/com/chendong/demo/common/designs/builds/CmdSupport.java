package com.chendong.demo.common.designs.builds;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: niezg date： 2019/12/3
 */
public abstract class CmdSupport implements ICmd {
    /**
     * 操作序列号，每个指令下发时会生成一个，可用于跟踪响应及去重
     */
    private Long sn;

    /**
     * 业务端下发时传入的sn号
     */
    @JSONField(serialize = false)
    private String bsn;

    @JSONField(serialize = false)
    private Integer dpid;

    @JSONField(serialize = false)
    private String encryptMode;

    /**
     * true是面向网关的指令，false是面向设备的指令
     */
    private Boolean gateway;

    @JSONField(serialize = false)
    private String reqType;

    @Override
    public Integer getDpid() {
        return dpid;
    }

    @Override
    public void setDpid(Integer dpid) {
        this.dpid = dpid;
    }

    @Override
    public Boolean getGateway() {
        return gateway;
    }

    @Override
    public void setGateway(Boolean gateway) {
        this.gateway = gateway;
    }

    @Override
    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    @Override
    public String getBsn() {
        return bsn;
    }

    @Override
    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    @Override
    public String getEncryptMode() {
        return encryptMode;
    }

    @Override
    public void setEncryptMode(String encryptMode) {
        this.encryptMode = encryptMode;
    }

    @Override
    public String getReqType() {
        return reqType;
    }

    @Override
    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    @Override
    public String toJsonDP() {
        if (EncryptModeEnum.BASE64.getEncryptMode().equals(this.encryptMode)) {
            Map<Integer, String> base64Map = new HashMap<>();
            String cmdStr = JSON.toJSONString(this);
            cmdStr = Base64.getEncoder().encodeToString(cmdStr.getBytes());
            base64Map.put(this.getDpid(), cmdStr);
            return JSON.toJSONString(base64Map);
        } else if (EncryptModeEnum.ENCODESTR.getEncryptMode().equals(this.encryptMode)) {
            Map<Integer, String> encodeStrMap = new HashMap<>();
            String cmdStr = JSON.toJSONString(this);
            encodeStrMap.put(this.getDpid(), cmdStr);
            return JSON.toJSONString(encodeStrMap);
        } else {
            Map<Integer, ICmd> map = new HashMap<>();
            map.put(this.getDpid(), this);
            return JSON.toJSONString(map);
        }
    }

    public CmdSupport() {
        sn = PrimaryIdGenerator.generateLong();
    }
}
