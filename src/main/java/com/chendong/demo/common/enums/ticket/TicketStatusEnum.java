package com.chendong.demo.common.enums.ticket;

/**
 *
 * @author dong.chen
 */
public enum TicketStatusEnum {

    // 通用的工单状态
    WAITING_ASSIGN(7, "待分派"), PENDING(0, "待处理"), IN_PROGRESS(1, "处理中"),
    // 待客户反馈
    WAITING_REPLY(53, "待客户反馈"), HANDLED(2, "已处理"), FIXED(3, "已解决"), REOPEN(4, "重开"),
    // 完结
    CLOSED(5, "已完结"),
    // 用户取消
    REVOKE(52, "已关闭"), DELETED(6, "已删除"),

    // 服务类工单状态
    ORDER_PENDING(0, "待支付"), ORDER_PAID(1, "已支付"), ORDER_DELIVERED(2, "待收货"), ORDER_RECEIPT_CONFIRMED(3, "已收货（审核中）"),

    ORDER_AUDITING(10, "审核中（待处理）"), ORDER_APPROVED(11, "审核通过（处理中）"), ORDER_SERVICE_COMPLETE(12, "服务已完成"),

    ORDER_CANCEL_REFUNDING(20, "已取消（退款中）"), ORDER_CANCEL_REFUNDED(21, "已退款（订单关闭）"), ORDER_CANCEL_CLOSE(22, "已取消（订单关闭）"),

    ORDER_RETURN_REFUNDING(30, "已退回（退款中）"), ORDER_RETURN_REFUNDED(31, "已退款（订单关闭）"), ORDER_RETURN_CLOSE(32, "已退回（订单关闭）"),

    ORDER_CLOSE(40, "已关闭"), ORDER_EVALUATED(41, "已评价"),

    // WWA 认证 服务工单 特有
    ORDER_CERTIFIED_SUCCESS(42, "认证通过"), ORDER_CERTIFIED_FAILED(43, "认证不通过"),

    // ALEXA 新增业务状态
    ORDER_DENY(50, "审核未通过"), ORDER_POST_SAMPLE(51, "已寄样（开发中）"),
    // ODM产品定制状态
    ODM_DEVELOPING(54, "开发中"), ODM_WAITING_ACCEPTANCE(55, "开发完成待验收"),
    // 社区saas
    EVALUATED(56, "已评价"), COMMENTS_EVALUATION(57, "已回复评价");

    private int value;

    private String name;

    TicketStatusEnum(int type, String name) {
        this.value = type;
        this.name = name;
    }

    public static TicketStatusEnum getByValue(int value) {
        for (TicketStatusEnum statusEnum : values()) {
            if (statusEnum.value == value) {
                return statusEnum;
            }
        }
        return null;
    }

    public static boolean canChangeTo(int from, int to) {
        TicketStatusEnum statusFrom = getByValue(from);
        TicketStatusEnum statusTo = getByValue(to);

        if (statusFrom == null || statusTo == null) {
            return false;
        }
        if (statusFrom == statusTo) {
            return false;
        }
        if (statusFrom == CLOSED || statusFrom == DELETED) {
            return false;
        }
        return true;
    }

    public static boolean isEnd(int status) {
        return (status == CLOSED.getValue()) || (status == REVOKE.getValue());
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
