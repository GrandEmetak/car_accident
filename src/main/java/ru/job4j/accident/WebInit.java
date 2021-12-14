package ru.job4j.accident;

import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import ru.job4j.accident.config.JdbcConfig;
import ru.job4j.accident.config.WebConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 0. Spring MVC [#6877]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * Когда tomcat загружает наше приложение, он ищет класс, который расширяет WebApplicationInitializer.
 * Tomcat создает контекст Spring и загружает DispatcherServlet.
 * DispatcherServlet будет обрабатывать все запросы. Он доступен по адресу, указанному в addMapping().
 * 3. -@ModelAttribute. Создание инцидента. [#261013]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 0. Spring DataSource [#6878]
 * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * Подключим класс конфигурации. -JdbcConfig.class
 * ac.register(WebConfig.class, JdbcConfig.class);
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletCxt) {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class, JdbcConfig.class);
        ac.refresh();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        filter.setForceRequestEncoding(true);
        FilterRegistration.Dynamic encoding = servletCxt.addFilter("encoding", filter);
        encoding.addMappingForUrlPatterns(null, false, "/*");
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
