package com.xy.t_bytecode.bean;

public class LoginPresenter {

    public void enterLoginPage(){
        System.out.println("---this is log data---");
    }

    public void login(){
        System.out.println("---user login--");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
