package com.chendong.demo.common.designs.command.invoker;

import com.chendong.demo.common.designs.command.Command;

/**
 * 命令的发送者
 *
 * @author dong.chen
 * @date 2021 08 18 9:03
 */
public class RemoteInvoker {

    /**
     * 命令接口，类似于插槽
     */
    Command slot;

    public RemoteInvoker() {}

    public void bindCommand(Command command) {
        this.slot = command;
    }

    public void buttonOn() throws Exception {
        slot.execute();
    }

    public void cancel() throws Exception {
        slot.undo();
    }
}
