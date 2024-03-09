package tr.odamede.javaworks.springvalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ResponseDto {

    @NotBlank(message = "tummesajlar response da null olamaz")
    private String tumMesajlar;

    @NotNull(message = "UUID response da null olamaz")
    private UUID uuid;

    public String getTumMesajlar() {
        return tumMesajlar;
    }

    public void setTumMesajlar(String tumMesajlar) {
        this.tumMesajlar = tumMesajlar;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
