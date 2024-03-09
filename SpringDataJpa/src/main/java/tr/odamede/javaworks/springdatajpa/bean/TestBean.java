package tr.odamede.javaworks.springdatajpa.bean;

import org.springframework.stereotype.Component;
import tr.odamede.javaworks.springdatajpa.entity.Author;
import tr.odamede.javaworks.springdatajpa.entity.Employee;
import tr.odamede.javaworks.springdatajpa.repository.AuthorRepository;
import tr.odamede.javaworks.springdatajpa.repository.EmployeeRepository;

import java.util.List;

@Component
public class TestBean {

    private final EmployeeRepository employeeRepository;

    private final AuthorRepository authorRepository;

    public TestBean(EmployeeRepository employeeRepository, AuthorRepository authorRepository) {
        this.employeeRepository = employeeRepository;
        this.authorRepository = authorRepository;
    }

    public void testRepositories(){
        List<Author> all = authorRepository.findAll();
        System.out.println("1");
        all.forEach(System.out::println);
        List<Employee> all1 = employeeRepository.findAll();
        System.out.println("2");

    }

}
