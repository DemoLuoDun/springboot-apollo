package com.example.apollo.bean;

/**
 * @author demoluo
 * Date 2019/11/15
 */
public class ApolloBean {

    private int timeout;
    private int batch;

    public void setTimeout(int timeout) {
        // 用于打印变化的值
        System.out.println("timeout打印的old:" + this.timeout + "\tnew:" + timeout);
        this.timeout = timeout;
    }

    public void setBatch(int batch) {
        System.out.println("batch打印的old:" + this.batch + "\tnew:" + batch);
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }

    @Override
    public String toString() {
        return "ApolloBean{" +
                "timeout=" + timeout +
                ", batch=" + batch +
                '}';
    }
}
