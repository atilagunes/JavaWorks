package tr.odamede.javaworks.springbeanannotationdiff;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/*
Controller annotation comes from Component annotation
If you need a traditional web application, Controller is suitable. you can return view name in methods.
 */
@Controller
@RequestMapping("/v1/annotation-test-controller")
public class AnnotationTestController {

    public AnnotationTestController() {
        System.out.println("AnnotationTestController initialized");
    }

    @RequestMapping(value = "/get-controller-method-only-with-request-and-response", method = RequestMethod.GET)
    public void getControllerMethod(HttpServletRequest request, HttpServletResponse response){
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



    /*
    Don't use return type and Print Writer together in rest services. Otherwise, it thinks that you return viewName
    In RestController, you can not return view name also.
     */
    @RequestMapping(value = "/get-controller-method-with-response-body-and-request-and-response", method = RequestMethod.GET)
    @ResponseBody
    public String getControllerMethodWithResponseBody(HttpServletRequest request, HttpServletResponse response){
        Locale locale = request.getLocale();
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        writer.println("Locale : " + locale.getLanguage());
//        response.setStatus(HttpStatus.OK.value());
        return "thisIsNotAViewName";
    }


}
