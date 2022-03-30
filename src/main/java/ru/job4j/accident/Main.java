package ru.job4j.accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Сгенерируем пароль для администратора.
 * Для этого создадим обычный Main класс с методом Main.
 */
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
        // String pwd = encoder.encode("123456");
        System.out.println(pwd);
    }
}
