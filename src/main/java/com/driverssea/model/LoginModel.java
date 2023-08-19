package com.driverssea.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotNull(message = "Username Required")
    @Size(min =3, max = 15, message = "Username must be between 3 to 15 letters")
    String username;

    @NotNull(message = "Password Required")
    @Size(min =8, max = 15, message = "Password must be between 8 to 15 letters")
    String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginModel() {
    }

    @Override
    public String toString() {
        return "loginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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
}
