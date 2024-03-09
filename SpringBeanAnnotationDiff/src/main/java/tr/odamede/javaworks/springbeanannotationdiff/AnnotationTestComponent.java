package tr.odamede.javaworks.springbeanannotationdiff;

import org.springframework.stereotype.Component;
/*
Component annotation has very general spectrum. If you cant find proper annotation like Controller, RestController, Service,
Repository then you can mark with Component annotation. Other annotations come from component annotations. You can create
a bean with this annotation.
 */

@Component
public class AnnotationTestComponent {
    public AnnotationTestComponent() {
        System.out.println("AnnotationTestComponent is initialized");
    }
}
