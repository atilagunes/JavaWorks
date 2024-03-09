package com.odamede.javanotes.springwebrestcrud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/rest-example-one")
public class RestExampleController {


    // call example: /v1/rest-example-one/Merhaba Canim/230ced7e-0eae-472f-b768-752ffbaf74b4/5
    @GetMapping("/{stringDifferentNameValue}/{uuidValue}/{integerValue}")
    public ResponseEntity<String> getWithPathVariable(@PathVariable("stringDifferentNameValue") String stringValue,@PathVariable UUID uuidValue,@PathVariable("integerValue") Integer integerValue){
        String result = "<h3>StringValue : "+stringValue + "</h3><h3>UUIDValue : "+ uuidValue.toString()+"</h3><h3>IntegerValue: "+integerValue+"</h3>";
        return ResponseEntity.of(Optional.of(result));
    }

    // call example: /v1/rest-example-one/request-param?stringValue=Merhaba Dev&uuidValue=230ced7e-0eae-472f-b768-752ffbaf74b4&integerValue=5
    @GetMapping("/request-param")
    public ResponseEntity<String> getWithRequestParam(@RequestParam String stringValue,@RequestParam UUID uuidValue, @RequestParam Integer integerValue){
        String result = "<h3>StringValue : "+stringValue + "</h3><h3>UUIDValue : "+ uuidValue.toString()+"</h3><h3>IntegerValue: "+integerValue+"</h3>";
        return ResponseEntity.of(Optional.of(result));
    }

/*
    call example: /v1/rest-example-one/like-request-param?stringValue=Merhaba Dev&uuidValue=230ced7e-0eae-472f-b768-752ffbaf74b4&integerValue=5
    In record, you can't use @NotNull annotation yet, because in NotNull annotation, ElementType.RECORD_COMPONENT is not used.

    In this example, you can use a record or dto without any annotation on it to use it like request param parameters.
 */
    @GetMapping("/like-request-param")
    public ResponseEntity<String> getWithRecordLikeRequestParam(RequestRecord record){
        String result = "<h3>StringValue : "+record.stringValue() + "</h3><h3>UUIDValue : "+ record.uuidValue().toString()+"</h3><h3>IntegerValue: "+record.integerValue()+"</h3>";
        return ResponseEntity.of(Optional.of(result));
    }


    // call example: /v1/rest-example-one/request-param-not-required?stringDifferentValueName=Merhaba Dev&integerValue=5
    @GetMapping("/request-param-not-required")
    public ResponseEntity<String> getWithRequestParamNotRequiredAndDifferentParamName(@RequestParam("stringDifferentValueName") String stringValue,@RequestParam(required = false) UUID uuidValue, @RequestParam Integer integerValue){
        String result = "<h3>StringValue : "+stringValue + "</h3><h3>IntegerValue: "+integerValue+"</h3>";
        if(uuidValue!=null)
            result += "</h3><h3>UUIDValue: "+uuidValue+"</h3>";
        return ResponseEntity.of(Optional.of(result));
    }

    // will go on with POST / PUT / DELETE


}
