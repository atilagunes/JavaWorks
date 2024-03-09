package tr.odamede.javaworks.springbeanannotationdiff;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Optional;

/*
RestController annotation comes from Controller annotation and it comes from Component annotation.
RestController <- Controller <- Component
You can also add to use HttpServletRequest and HttpServletResponse in method signature.

RestController can work with xml and json. You can check the projects related to Rest Services.
 */
@RestController
@RequestMapping(value = "/v1/annotation-test-rest")
public class AnnotationTestRestController {

    @GetMapping("/get-mapping-without-parameter")
    public ResponseEntity<HttpStatus> getMappingWithoutParameter(){
        return ResponseEntity.of(Optional.of(HttpStatus.OK));
    }

    @GetMapping("/get-mapping-with-http-servlet-request")
    public void getMappingWithHttpServerRequest(HttpServletRequest request, HttpServletResponse response) {
        Locale locale = request.getLocale();
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.println("Locale : " + locale.getLanguage());
        response.setStatus(HttpStatus.OK.value());
    }

    @GetMapping("/get-mapping-with-http-servlet-request-and-id/{id}")
    public void getMappingWithHttpServerRequest(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") Integer id) {
        Locale locale = request.getLocale();
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.println("Locale : " + locale.getLanguage());
        writer.println("Id value : "+id);
        response.setStatus(HttpStatus.OK.value());
    }

}
