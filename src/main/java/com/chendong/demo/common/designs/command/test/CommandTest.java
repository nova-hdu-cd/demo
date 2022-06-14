package com.chendong.demo.common.designs.command.test;

import com.chendong.demo.common.designs.command.concrete.LightCommand;
import com.chendong.demo.common.designs.command.invoker.RemoteInvoker;
import com.chendong.demo.common.designs.command.receiver.LightReceiver;

/**
 * 命令模式的本质就是对命令进行封装 将发出命令的责任和执行命令的责任分割开
 *
 * @author dong.chen
 * @date 2021 08 18 9:04
 */
public class CommandTest {

    public static void main(String[] args) throws Exception {

        // 【命令的接收者】 Receiver
        // 【具体命令对象】 ConcreteCommand
        LightReceiver lightReceiver = new LightReceiver();
        LightCommand lightCommand = new LightCommand(lightReceiver);

        // 【命令的发送者】 Invoker
        // 【绑定具体命令】 Invoker::bind
        RemoteInvoker remote = new RemoteInvoker();
        remote.bindCommand(lightCommand);

        // 【执行命令】
        remote.buttonOn();
        remote.cancel();

    }

}
