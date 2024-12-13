package springlabs.news;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import springlabs.news.test.BeansTester;
import springlabs.news.test.TestBean;

@SpringBootApplication
public class NewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }

    @Bean
    @Scope("prototype")
    TestBean showBean() {
        return new TestBean();
    }

    BeansTester beansTester() {
        return new BeansTester(showBean(), showBean());
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> beansTester().compareBeans();
    }

}
