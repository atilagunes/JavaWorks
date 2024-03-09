package tr.odamede.javaworks.springvalidation;

import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public class RequestDto {

    @Min(value = 1, message = "lower than the lowest number")
    @Max(value = 1000, message = "greater than the largest number")
    private int id;

    @NotBlank(message="name alanini bos birakmayiniz")
    private String name;

    @NotNull(message = "UUID bos birakmayiniz")
    private UUID uuid;


    @NotEmpty(message = "Liste bos olamaz")
    private List<String> liste;

    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> liste) {
        this.liste = liste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
