package dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegisterFlatDto {
    private String flat_name;
    private String flat_password;
    private String flat_street;
    private String flat_number;
    private String flat_city;

    public String getFlat_name() {
        return flat_name;
    }

    public String getFlat_password() {
        return flat_password;
    }

    public String getFlat_street() {
        return flat_street;
    }

    public String getFlat_number() {
        return flat_number;
    }

    public String getFlat_city() {
        return flat_city;
    }
}

