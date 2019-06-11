package dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class LoginFlatDto {
    @NotNull
    @NotEmpty
    private String flat_name;
    @NotNull
    @NotEmpty
    private String password;
    @Positive
    private int residentId;

    public int getResidentId() {
        return residentId;
    }

    public String getName() {
        return flat_name;
    }

    public String getPassword() {
        return password;
    }

}
