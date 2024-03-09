package tr.odamede.javaworks.springvalidation;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequestMapping()
public class ValidationBean {

    private final ValidationHelper helper;

    public ValidationBean(ValidationHelper helper) {
        this.helper = helper;
    }

    public ResponseDto validateTestOkDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setId(5);
        requestDto.setName("Atila");
        requestDto.setUuid(UUID.randomUUID());
        List<String> liste = new ArrayList<>();
        liste.add("Merhaba");
        requestDto.setListe(liste);
        return helper.validateTestOkDto(requestDto);
    }

    public ResponseDto validateTestNotNullDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setName("Atila");
        List<String> liste = new ArrayList<>();
        liste.add("Merhaba");
        requestDto.setListe(liste);
        return helper.validateTestValidDto(requestDto);
    }

    public ResponseDto validateTestNotBlankDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setName("    ");
        requestDto.setUuid(UUID.randomUUID());
        List<String> liste = new ArrayList<>();
        liste.add("Merhaba");
        requestDto.setListe(liste);
        return helper.validateTestValidDto(requestDto);
    }

    public ResponseDto validateTestNotEmptyDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setName("Atila");
        requestDto.setUuid(UUID.randomUUID());
        List<String> liste = new ArrayList<>();
        requestDto.setListe(liste);
        return helper.validateTestValidDto(requestDto);
    }

    public ResponseDto validateResponseNotNullDto(){

        return helper.validateResponseNotNullDto(new RequestDto());
    }

    public ResponseDto validateResponseNotBlankDto(){

        return helper.validateResponseNotBlankDto(new RequestDto());
    }

    public ResponseDto validateRequestMinDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setId(0);
        requestDto.setUuid(UUID.randomUUID());
        requestDto.setName("Atila");
        requestDto.setListe(List.of("Atila"));
        return helper.validateTestValidDto(requestDto);
    }

    public ResponseDto validateRequestMaxDto(){
        RequestDto requestDto = new RequestDto();
        requestDto.setId(1001);
        requestDto.setUuid(UUID.randomUUID());
        requestDto.setName("Atila");
        requestDto.setListe(List.of("Atila"));
        return helper.validateTestValidDto(requestDto);
    }

    public void validateEmailOk(){
        helper.validateEmail("atila@atila.com");
    }

    public void validateEmailNotOk(){
        helper.validateEmail("atila");
    }

    public void validatePatternOk(){
        helper.validatePattern("192.168.1.1");
    }
    public void validatePatternNotOk(){
        helper.validatePattern("192.168.200.1.5");
    }

    public void validate(){
        helper.validate(new RequestDto());
    }


}
