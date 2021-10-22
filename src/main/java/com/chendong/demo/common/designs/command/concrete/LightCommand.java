package com.chendong.demo.common.designs.command.concrete;

import com.chendong.demo.common.designs.command.Command;
import com.chendong.demo.common.designs.command.receiver.LightReceiver;

/**
 * 相关操作命令对象
 * 每一个命令都只是调用接收者的行为
 *
 * @author dong.chen
 * @date 2021 08 18 8:56
 */
public class LightCommand implements Command {

    /**
     * 具体命令的接收者
     */
    LightReceiver lightReceiver;

    public LightCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() throws Exception {
        lightReceiver.lightOn();
        lightReceiver.lighting();
        lightReceiver.lightOff();
    }

    @Override
    public void undo() throws Exception {
        Thread.sleep(2000);
        lightReceiver.lightUndo();
    }

}
