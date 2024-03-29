package com.odamede.springinterceptor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SomeController {

    @GetMapping()
    public ResponseEntity<String> returnSomeValue(){
        return ResponseEntity.ok("Return Value");
    }

}
