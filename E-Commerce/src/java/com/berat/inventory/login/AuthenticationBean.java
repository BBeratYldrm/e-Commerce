package com.berat.inventory.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AuthenticationBean {

    private String username;

    private String password;

    private boolean signIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String login() {
        if (username.equals("Berat") && password.equals("12345")) {
            signIn = true;
            return "Home";
        } else {
            signIn = false;
            return "Login";
        }
    }
}
