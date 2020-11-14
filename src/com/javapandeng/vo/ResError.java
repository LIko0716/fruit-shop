package com.javapandeng.vo;

/**
 * @author hangzhi1063
 * @date 2020/11/7 12:57
 */
public class ResError {
    String error1;
    String error2;
    String error3;

    public ResError() {
    }

    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    public String getError2() {
        return error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }

    public String getError3() {
        return error3;
    }

    public void setError3(String error3) {
        this.error3 = error3;
    }

    public ResError(String error1, String error2, String error3) {
        this.error1 = error1;
        this.error2 = error2;
        this.error3 = error3;
    }
}
