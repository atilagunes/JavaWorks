package tr.odamede.javaworks.springvalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringValidationApplication.class)
@AutoConfigureMockMvc
class ValidationBeanTest {

    @Autowired
    private ValidationBean validationBean;

    @BeforeEach
    void setUp() {

    }

    @Test
    void validateTestOkDto() {
        ResponseDto responseDtoResponseEntity = validationBean.validateTestOkDto();
        assertTrue(responseDtoResponseEntity.getUuid() != null);
    }

    @Test
    void validateTestNotNullDto() {

        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateTestNotNullDto());
        String expectedMessage = "UUID bos birakmayiniz";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void validateTestNotBlankDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateTestNotBlankDto());
        String expectedMessage = "name alanini bos birakmayiniz";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validateTestNotEmptyDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateTestNotEmptyDto());
        String expectedMessage = "Liste bos olamaz";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validateResponseNotNullDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateResponseNotNullDto());
        String expectedMessage = "UUID response da null olamaz";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validateResponseNotBlankDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateResponseNotBlankDto());
        String expectedMessage = "tummesajlar response da null olamaz";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void validateRequestMinDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateRequestMinDto());
        String expectedMessage = "lower than the lowest number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validateRequestMaxDto() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateRequestMaxDto());
        String expectedMessage = "greater than the largest number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void validateEmailOk() {
        validationBean.validateEmailOk();

    }

    @Test
    public void validateEmailError() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validateEmailNotOk());
        String expectedMessage = "Wrong email format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validatePatternOk() {
        validationBean.validatePatternOk();

    }

    @Test
    public void validatePatternNotOk() {
        Exception exception = assertThrows(RuntimeException.class, () -> validationBean.validatePatternNotOk());
        String expectedMessage = "Wrong pattern format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validate() {
        validationBean.validate();

    }


}