package com.example.exceptionhw;


import com.example.exceptions.WrongLoginException;
import com.example.exceptions.WrongPasswordException;

@org.springframework.stereotype.Service
public class SignInService {

    public static void signIn(String login, String password, String confirmPassword) {
        if (!login.matches("[a-z_0-9]+") || !password.matches("[a-z_0-9]+") || !confirmPassword.matches("[a-z_0-9]+")) throw new IllegalArgumentException();
        if (login.length()>20) throw new WrongLoginException();
        if (!password.equals(confirmPassword)) throw new WrongPasswordException();
        }
    }

