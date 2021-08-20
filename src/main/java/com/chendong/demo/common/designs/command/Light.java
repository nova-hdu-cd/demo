package com.chendong.demo.common.designs.command;

/**
 * 命令的接收者
 *
 * @author dong.chen
 * @date 2021 08 18 8:55
 */
public class Light {

    public void lightOn() {
        System.out.println("[1] light is on!");
    }

    public void lighting() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("[1] light is lighting!");
        }
    }

    public void lightOff() {
        System.out.println("[1] light is off!");
    }

    public void lightUndo(){
        System.out.println("[1] light is undoing!");
    }

}
