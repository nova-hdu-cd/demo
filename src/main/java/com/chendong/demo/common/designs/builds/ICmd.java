package com.chendong.demo.common.designs.builds;

/**
 * @author dong.chen
 */
public interface ICmd extends ICmdFormatter {

    /**
     * bsn
     */
    String getBsn();

    void setBsn(String bsn);

    Long getSn();

    /**
     * dpId
     */
    Integer getDpid();

    void setDpid(Integer dpId);

    /**
     * encryptMode
     */
    String getEncryptMode();

    void setEncryptMode(String encryptMode);

    /**
     * gateway
     */
    Boolean getGateway();

    void setGateway(Boolean gateway);

    /**
     * reqType
     */
    String getReqType();

    void setReqType(String reqType);

}