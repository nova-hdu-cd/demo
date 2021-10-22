package com.chendong.demo.common.designs.builds;

/**
 * @author dong.chen
 * @date 2021 08 23 14:19
 */
public abstract class AbstractCmdBuilder<T extends ICmd, TB extends AbstractCmdBuilder<T, TB>> {

    private String bsn;

    private String encryptMode;

    private String reqType;

    public TB withBsn(String bsn) {
        this.bsn = bsn;
        return (TB) this;
    }

    public TB withEncryptMode(String encryptMode) {
        this.encryptMode = encryptMode;
        return (TB) this;
    }

    public TB withReqType(String reqType) {
        this.reqType = reqType;
        return (TB) this;
    }

    public final T build() {
        Class<T> clazz = cmdClass();
        T cmd = ObjectUtils.newInstance(clazz);
        appendBsn(cmd);
        appendEncryptMode(cmd);
        appendReqType(cmd);
        addFields(cmd);
        return cmd;
    }

    protected abstract Class<T> cmdClass();

    private void appendReqType(T cmd) {
        cmd.setReqType(this.reqType);
    }

    private void appendBsn(T cmd) {
        cmd.setBsn(this.bsn);
    }

    private void appendEncryptMode(T cmd) {
        cmd.setEncryptMode(this.encryptMode);
    }

    protected abstract void addFields(T cmd);

}






