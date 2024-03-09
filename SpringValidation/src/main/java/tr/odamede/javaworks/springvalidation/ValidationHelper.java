package tr.odamede.javaworks.springvalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Set;
import java.util.UUID;

@Component
@Validated
public class ValidationHelper {

    //jakarta.validation.Validator
    private final Validator validator;

    public ValidationHelper() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    public ResponseDto validateTestOkDto(@Valid RequestDto requestDto){
        ResponseDto responseDto = new ResponseDto();
        String tumMesajlar = "Name : "+requestDto.getName()+"\n";
        tumMesajlar += "Id : "+requestDto.getId()+"\n";
        tumMesajlar += "UUID : "+requestDto.getUuid().toString()+"\n";
        System.out.println(tumMesajlar);
        responseDto.setUuid(UUID.randomUUID());
        responseDto.setTumMesajlar(tumMesajlar);
        return responseDto;
    }

    public ResponseDto validateTestValidDto(@Valid RequestDto requestDto){
        return new ResponseDto();
    }


    public @Valid ResponseDto validateResponseNotNullDto(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setTumMesajlar("sometext written just for not getting error");
        return responseDto;
    }

    public @Valid ResponseDto validateResponseNotBlankDto(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setTumMesajlar("  ");
        responseDto.setUuid(UUID.randomUUID());
        return responseDto;
    }

    public void validateEmail(@Email(message = "Wrong email format", regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email){
        // TODO document why this method is empty
    }



    public void validatePattern(@Pattern(message = "Wrong pattern format",regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$") String ipAddress){

    }

    public void validate(RequestDto requestDto) {
        Set<ConstraintViolation<RequestDto>> violations = validator.validate(requestDto);
//        if (!violations.isEmpty()) {
//            throw new ConstraintViolationException(violations);
//        }
        if(!violations.isEmpty()) {
            for(ConstraintViolation<RequestDto> violation : violations) {
                System.err.println("Violation : "+violation.getMessage());
            }
        }
    }


}
