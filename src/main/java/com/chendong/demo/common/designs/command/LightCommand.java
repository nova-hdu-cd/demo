package com.chendong.demo.common.designs.command;

/**
 * 相关操作命令对象
 * 每一个命令都只是调用接收者的行为
 *
 * @author dong.chen
 * @date 2021 08 18 8:56
 */
public class LightCommand implements Command {

    /**
     * 命令的接受者
     */
    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() throws Exception {
        light.lightOn();
        light.lighting();
        light.lightOff();
    }

    @Override
    public void undo() throws Exception {
        Thread.sleep(2000);
        light.lightUndo();
    }

}
