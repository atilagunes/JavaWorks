package tr.odamede.javaworks.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.odamede.javaworks.springdatajpa.bean.TestBean;

@SpringBootApplication
public class SpringDataJpaApplication  implements CommandLineRunner {

    private final TestBean testBean;

    public SpringDataJpaApplication(TestBean testBean) {
        this.testBean = testBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner worked");
        testBean.testRepositories();
    }

}
