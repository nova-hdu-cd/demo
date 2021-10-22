package com.chendong.demo.common.designs.command.receiver;

/**
 * @author dong.chen
 * @date 2021 08 27 15:49
 */
public class RatIrReceiver {

    private Integer irId;

    private String irCode;

    private Integer rrId;

    private Integer statusId;

    private String statusaName;

    public void risingCcb() {
        System.out.println("上升CCB!");
    }

    public void backIr(Integer statusId) {
        System.out.println("IR退回到" + statusId + "状态！");
    }

}
