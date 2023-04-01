package com.example.exceptionhw;

import com.example.exceptions.WrongLoginException;
import com.example.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signIn")
public class Controller {
    private final SignInService signInService;

    public Controller(SignInService signInService) {
        this.signInService = signInService;
    }

    @GetMapping()
    public String checkInformation(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        try {
            signInService.signIn(login, password, confirmPassword);
            return "True: Супер! Данные верны";
        } catch (WrongLoginException e) {
            return "False: Логин слишком длинный";
        } catch (WrongPasswordException e) {
            return "False: Пароли не совпадают";
        } catch (IllegalArgumentException e) {
            return "False: Недопустимые аргументы";
        } finally {
            System.out.println("Работа метода checkInformation окончена");
        }
    }
}
