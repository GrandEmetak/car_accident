package ru.job4j.accident;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Конфигурирование Spring
 * Создадим отдельный класс, в котором сделаем настройки для авторизации.
 * +
 * Этот класс нужно прописать в загрузку приложения WebInit.
 * 0. Spring Security [#6879]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * <p>
 * 1. Авторизация через JDBC [#2094]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Откройте класс SecurityConfig и измените настройку авторизации.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource ds;

    /**
     * Метод configure(auth) содержит описание, как искать пользователей.
     * В этом примере мы загружаем их в память.
     * У каждого пользователя есть роль. По роли мы определяем, что пользователь может делать .
     * +  @Autowired
     * private PasswordEncoder passwordEncoder;
     * protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     * auth.inMemoryAuthentication()
     * .passwordEncoder(passwordEncoder)
     * .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
     * .and()
     * .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
     * 1. Авторизация через JDBC [#2094]
     * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
     * Откройте класс SecurityConfig и измените настройку авторизации.
     * По умолчанию мы добавляем пользователя user с паролем 123456.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(ds)
                .withUser(User.withUsername("user")
                        .password(passwordEncoder().encode("123456"))
                        .roles("USER"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Метод configure(http) содержит описание доступов и конфигурирование страницы входа в приложение.
     * - ссылки, которые доступны всем.
     * .antMatchers("/login")
     * .permitAll()
     * - ссылки доступны только пользователем с ролями ADMIN, USER.
     * .antMatchers("/**")
     * .hasAnyRole("ADMIN", "USER")
     * Настройка формы авторизации.
     * .formLogin()
     * .loginPage("/login")
     * .defaultSuccessUrl("/")
     * .failureUrl("/login?error=true")
     * .permitAll()
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/**")
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}
