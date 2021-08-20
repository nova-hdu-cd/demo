package com.chendong.demo.common.enums.ticket;

/**
 * @author dong.chen
 */

public enum KunlunTicketStatus {
    /**
     * 未处理
     */
    UNSOLVED(1, "unsolved", "未处理"),
    /**
     * 处理中
     */
    PROCESSING(2, "processing", "处理中"),
    /**
     * 处理完成
     */
    SOLVED(3, "solved", "处理完成"),
    /**
     * 已取消
     */
    CANCELED(4, "canceled", "已取消");

    private int id;

    private String code;

    private String mean;

    KunlunTicketStatus(int id, String code, String mean) {
        this.id = id;
        this.code = code;
        this.mean = mean;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getMean() {
        return mean;
    }
}
