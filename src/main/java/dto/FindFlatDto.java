package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FindFlatDto {
    @NotNull
    @NotEmpty
    private int residentId;

    public int getResidentId() {
        return residentId;
    }
}
