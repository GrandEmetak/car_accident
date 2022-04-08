public class WebInit implements WebApplicationInitializer
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
 * 1. Spring ORM [#2093]00
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * Заменим JdbcConfig на HbmConfig.
 *  ac.register(WebConfig.class, JdbcConfig.class);
 *
 * ac.register(WebConfig.class, HbmConfig.class);
 * 2. Spring Data [#296073]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * И заменим настройки.
 *- ac.register(WebConfig.class, DataConfig.class);
 * 0. Spring Security [#6879]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Создадим отдельный класс, в котором сделаем настройки для авторизации.
 *тот класс нужно прописать в загрузку приложения WebInit.
 * ac.register(WebConfig.class, SecurityConfig.class);
 */

  public class WebConfig {
 /**
  * 0. Spring MVC [#6877]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
  * В нем появилась аннотация ComponentScan. Она сканирует проект и загружает бины в контекст.
  * Внутри этого класса создается объект ViewResolver.
  * Spring использует этот объект для поиска jsp. В нем сразу подключен JSTL.
  *@Configuration
 *   @ComponentScan("ru.job4j.accident")
  */



public class IndexControl {
/**
 * контроллер для главной страницы
 * -@Controller для обработчиков запросов.
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * как выгледел ранее класс class IndexControl смотреть на git
 * переходим на работу с JDBC SPRING
 * 0. Spring DataSource [#6878]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * 1. Spring ORM [#2093]
 * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * 2. Spring Data [#296073]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * Поправим настройку констроллера.
 * было - private final AccidentJdbcTemplate accidents;
 * public IndexControl(AccidentJdbcTemplate accidents) {
 * this.accidents = accidents;
 * }
 * заменено на - private final AccidentHibernate accidents;
 * public IndexControl(AccidentHibernate accidents){
 * this.accidents=accidents;
 * }
 * - @GetMapping("/")
 * public String index(Model model) {
 * model.addAttribute("accidents", accidents.getAll());
 * return "index";
 * }
 * позднее заменено на
 * private final AccidentRepository accidents; *
 * public IndexControl(AccidentRepository accidents) {
 * this.accidents = accidents;
 * }
 * -@GetMapping("/")
 * public String index(Model model) {
 * List<Accident> res = new ArrayList<>();
 * accidents.findAll().forEach(res::add);
 * res.stream().forEach(System.out::println);
 * model.addAttribute("accidents", res);
 * return "index";
 * }
 * + в конструктор котроллера нельзя класс передавать при данной аннотации, надо интерфейс.
 * 1. Авторизация через JDBC [#2094]00
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим вывод авторизованного пользователя на индексной странице.
 * + заменим
 * private final AccidentRepository accidents;
 * public IndexControl(AccidentRepository accidents) {
 * this.accidents = accidents;
 * }
 * -@GetMapping("/")
 * public String index(Model model) {
 * List<Accident> res = new ArrayList<>();
 * accidents.findAll().forEach(res::add);
 * res.stream().forEach(System.out::println);
 * model.addAttribute("accidents", res);
 * return "index";
 * }
 */


 public class AccidentHibernate {
 /**
  * 1. Spring ORM [#2093]
  * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.3. Template, ORM
  * В этот класс мы передаем объект SessionFactory.
  * Spring помог связать SessionFactory с AccidentHibernate.
  * Это все, что здесь сделал Spring.
  * @Repository
  */

  public class AccidentRepositoryService {
 /**
  * 2. Spring Data [#296073 #241197]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
  *@Service
  */


  public class AccidentService implements AccidentServiceInterface {
 /**
 * @Service
  * описывающий логику работы.
  * -@Service для классов с бизнес логикой
  * 2. IndexControl. Таблица и вид. [#2092 #235642]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
  * 4. Form с композиционным объектом [#305522]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
  * 5. Form с аргегационными объектами [#305523]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
  */

public class AccidentControl {
/**
*@Controller
 * 3. @ModelAttribute. Создание инцидента. [#261013]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 5. Form с аргегационными объектами [#305523]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */

  public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
 /**
  * Подключение фильтров происходит за счет добавления класса -
  * Он подключает DelegatingFilterProxy. Это главный фильтр, в котором идет обработка запросов.
  * Tomcat автоматически определяет такой класс и подключает эти фильтры.
  * 0. Spring Security [#6879]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
  */

public class LoginControl {
/**
*@Controller
 * Настроим контроллер.
 * 0. Spring Security [#6879]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 *
 */


 public class HbmConfig {
 /**
 * @Configuration
  * @PropertySource("classpath:app.properties")
 *  @EnableTransactionManagement
  * подключим Hibernate
  * 1. Spring ORM [#2093 #240116]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
  * Настройки SessionFactory
  * Создадим класс HbmConfig и добавим в него загрузку SessionFactory.
  * Заменим JdbcConfig на HbmConfig.
  * в классе WebInit
  * ac.register(WebConfig.class, HbmConfig.class);
  */

public class AccidentJdbcTemplate {
/**
/*@Repository*/
 * бин работает с хранилищем, класс для работы с базой.
 * 0. Spring DataSource [#6878]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * -@Repository - называется стереотипной аннотацией.
 * Это значит, что этот бин выполняет определенное назначение.
 * В данном случае @Repository указывает, что бин работает с хранилищем.
 */

public class AccidentMem {
/**
*@Repository
 * Хранилище инцидентов
 * 2. IndexControl. Таблица и вид. [#2092]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */

public class User {
/**
*@Entity
*@Table(name = "users")
 * Пользователь
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 * + Authority class
 * + Репозиторий interface AuthorityRepository
 * + Репозиторий interface UserRepository
 */

public class AccidentType {
/**
*@Entity
 @Table(name = "accident_types")
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.2. MVC
 */

 public class Main {
 /**
  * 2. Регистрация пользователя [#296069]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
  *Сгенерируем пароль для администратора.
  * Для этого создадим обычный Main класс с методом Main.
  *
  */

public class JdbcConfig {
/**
@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
 * подключим к проекту "Автонарушитель" базу данных.
 * На данном этапы мы напишем все через JDBC
 *  В данно классе - В нем нужно создать бин, который будет содержать пул соединений.
 * 0. Spring DataSource [#6878 #239808]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * - @PropertySource("classpath:app.properties")  -- эта аннотация говорит Spring считать файл.
 * Далее настройки можно получить через аннотацию @Value("${jdbc.driver}") String driver,
 * Метод ds загружает пул соединений.
 * Метод jdbc создает обертку для работы с базой.
 */

public class RegControl {
/**
@Controller
 * Controller
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 * + Authority class
 * + Репозиторий interface AuthorityRepository
 * + Репозиторий interface UserRepository
 * + User class
 */

public class Accident {
/**
@Entity
@Table(name = "accident")
 * Модель данных - правонарушения.
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * -@OneToMany() - потомучто в одном Ассиденкт будет много Rule
 *- @OneToMany(cascade = CascadeType.ALL - в случае удаления/добавления каскадом
 * , mappedBy = "accident")
 * - т.е эту связь ищи в поле Rule class private Accident accident -> @ManyToOne связанный с этим
 */


  public interface UserRepository extends CrudRepository<User, Integer> {
 /**
  * Repository
  * 2. Регистрация пользователя [#296069]
  * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
  * Добавим модели данных и репозитории для новых моделей.
  * + Authority class
  * + Репозиторий interface AuthorityRepository
  * + User class
  */

public class SecurityConfig extends WebSecurityConfigurerAdapter {
/**
@Configuration
@EnableWebSecurity
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
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим запросы авторизации и аутентификации.
 ---->
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
      * 2. Регистрация пользователя [#296069]
      * * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
      * изменен - было
      * auth.jdbcAuthentication()
      * .dataSource(ds)
      * .withUser(User.withUsername("user")
      * .password(passwordEncoder().encode("123456"))
      * .roles("USER"));
      *
      * @param auth
      * @throws Exception
      */
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {

     }
     ----->
     /**
          * Метод configure(http) содержит описание доступов и конфигурирование страницы входа в приложение.
          * - ссылки, которые доступны всем.
          * .antMatchers("/login") изменено на .antMatchers("/login", "/reg")
          * (- 2. Регистрация пользователя [#296069] 3.4.4. Security)
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
         protected void configure(HttpSecurity http) throws Exception {}
 */

public class HbmConfig {
/**
 * подключение Hibernate к проекту
 * Настройки SessionFactory
 * Заменим JdbcConfig на HbmConfig в классе WebInit
 * ac.register(WebConfig.class, HbmConfig.class);
 */
@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement












