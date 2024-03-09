package tr.odamede.javaworks.springbeanannotationdiff;

import org.springframework.stereotype.Service;

/*
Service is a kind of Component. In a layered application, it sembolize between Controller and Repository.
You can put business logics into it. You can manipulate date in it and you can flow data between other beans here.
*/

@Service
public class AnnotationTestService {

    public AnnotationTestService() {
        System.out.println("AnnotationTestService is initialized");
    }

}
