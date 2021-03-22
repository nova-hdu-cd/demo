package com.chendong.demo.response;

public class BaseResponse<T> {

    //返回内容
    private T resp;

    //返回条数
    private int totalNum;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public T getResp() {
        return resp;
    }

    public void setResp(T resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resp=" + resp +
                ", totalNum=" + totalNum +
                '}';
    }
}
