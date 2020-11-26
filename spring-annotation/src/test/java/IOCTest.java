import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.bean.Cat;
import com.atguigu.bean.Dog;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);


        Person person = applicationContext.getBean(Person.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        applicationContext.close();
    }

    @Test
    public void testBeanLifeCycle(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        Cat cat = applicationContext.getBean(Cat.class);
        applicationContext.close();
    }


    @Test
    public void testInterfaceAware(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Dog dog = applicationContext.getBean(Dog.class);
        System.out.println(dog.getApplicationContext());
        System.out.println(applicationContext);
    }


    /**
     *
     * 指定环境:
     *      1.可以加命令行参数 -Dspring.profiles.active=test
     *      2.可以用无参构造器，以代码的方式
     *
     */
    @Test
    public void testProfile() throws SQLException {
        // 有参构造器，需要用 命令行参数指定 profile
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        applicationContext.refresh();



        String[] dataSourceNames = applicationContext.getBeanNamesForType(DataSource.class);
        for (String dataSourceName : dataSourceNames) {
            System.out.println(dataSourceName);
        }
        DruidDataSource dataSourceTest = (DruidDataSource) applicationContext.getBean("dataSourceTest");
        System.out.println(dataSourceTest.getConnection());

    }
}
