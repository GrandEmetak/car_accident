package ru.job4j.accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 *Сгенерируем пароль для администратора.
 * Для этого создадим обычный Main класс с методом Main.
 *
 */
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
       // String pwd = encoder.encode("123456");
        System.out.println(pwd);
    }
}
