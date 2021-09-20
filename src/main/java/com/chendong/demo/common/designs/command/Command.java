package com.chendong.demo.common.designs.command;

/**
 * Command接口
 *
 * @author dong.chen
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute() throws Exception;

    /**
     * 撤销命令
     */
    void undo() throws Exception;

}
