package com.chendong.demo.common.designs.command.invoker;

import com.chendong.demo.common.designs.command.concrete.RatIrCommand;
import com.chendong.demo.common.designs.command.receiver.RatIrReceiver;

/**
 * @author dong.chen
 * @date 2021 08 27 15:56
 */
public class RatIrInvoker {

    private RatIrCommand ratIrCommand;

    public void bind(RatIrCommand command) {
        this.ratIrCommand = command;
    }

    public void risingCcb() {
        ratIrCommand.risingCcb();
    }

    public static void main(String[] args) {

        RatIrReceiver ratIrReceiver = new RatIrReceiver();
        RatIrCommand ratIrCommand = new RatIrCommand(ratIrReceiver);

        RatIrInvoker ratIrInvoker = new RatIrInvoker();
        ratIrInvoker.bind(ratIrCommand);

        ratIrInvoker.risingCcb();

    }

}
