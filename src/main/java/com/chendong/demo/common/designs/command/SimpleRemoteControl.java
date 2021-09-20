package com.chendong.demo.common.designs.command;

/**
 * 命令的发送者
 *
 * @author dong.chen
 * @date 2021 08 18 9:03
 */
public class SimpleRemoteControl {

    /**
     * 命令接口，类似于插槽
     */
    Command slot;

    public SimpleRemoteControl() {
    }

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
