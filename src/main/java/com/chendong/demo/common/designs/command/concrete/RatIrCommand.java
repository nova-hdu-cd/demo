package com.chendong.demo.common.designs.command.concrete;

import com.chendong.demo.common.designs.command.IrCommand;
import com.chendong.demo.common.designs.command.receiver.RatIrReceiver;

/**
 * @author dong.chen
 * @date 2021 08 27 15:53
 */
public class RatIrCommand implements IrCommand {

    private final RatIrReceiver ratIrReceiver;

    public RatIrCommand(RatIrReceiver ratIrReceiver) {
        this.ratIrReceiver = ratIrReceiver;
    }

    @Override
    public void risingCcb() {
        ratIrReceiver.risingCcb();
    }

    @Override
    public void backIr() {
        ratIrReceiver.backIr(11);
    }

    @Override
    public void analysis() {

    }
}
