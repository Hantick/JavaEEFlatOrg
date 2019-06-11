package dto;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class RegisterFlatDto {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    private String number;
    @NotNull
    @NotEmpty
    private String city;
    @Positive
    private int residentId;

    public int getResidentId() {
        return residentId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

}

