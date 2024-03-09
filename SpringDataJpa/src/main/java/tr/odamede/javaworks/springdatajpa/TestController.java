package tr.odamede.javaworks.springdatajpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.odamede.javaworks.springdatajpa.entity.Author;
import tr.odamede.javaworks.springdatajpa.entity.Employee;
import tr.odamede.javaworks.springdatajpa.repository.AuthorRepository;
import tr.odamede.javaworks.springdatajpa.repository.EmployeeRepository;

import java.util.Optional;

@RestController("/")
public class TestController {

    private final AuthorRepository authorRepository;

    private final EmployeeRepository employeeRepository;

    public TestController(AuthorRepository authorRepository, EmployeeRepository employeeRepository) {
        this.authorRepository = authorRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/yazar")
    public ResponseEntity<HttpStatus> yazarKaydet(@RequestBody Author author){
        if(!author.getBooks().isEmpty())
            author.getBooks().forEach(book -> book.setAuthor(author));
        authorRepository.save(author);
        return ResponseEntity.of(Optional.of(HttpStatus.CREATED));
    }

//    @PostMapping("/kitap")
//    public ResponseEntity<HttpStatus> kitapKaydet(@RequestBody Book book){
//
//    }

    @PostMapping("/calisan")
    public ResponseEntity<HttpStatus> calisanKaydet(@RequestBody Employee employee){
        if(!employee.getEmails().isEmpty()){
            employee.getEmails().forEach(email -> email.setEmployee(employee));
        }
        employeeRepository.save(employee);
        return ResponseEntity.of(Optional.of(HttpStatus.CREATED));
    }

//    @PostMapping("/email")
//    public ResponseEntity<HttpStatus> emailKaydet(@RequestBody Email email){
//
//    }


}
